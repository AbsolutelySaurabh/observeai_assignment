package main.datamanager; /**
 * @author AbsolutelySaurabh
 */

import main.constant.Constants;
import main.data.UserData;
import main.data.ShortUrl;

import java.util.HashMap;

public class DataManager {

    private static DataManager dataManager;
    public static HashMap<Integer, UserData> clientDataMap;
    public static HashMap<String, ShortUrl> shortToLongUrlMap;
    private static int longUrlId;

    public static DataManager getInstance(){
        if(dataManager == null){
            dataManager = new DataManager();
        }
        return dataManager;
    }

    public int getLongUrlId(){
        return longUrlId;
    }

    public void incrementLongUrlId(){
        longUrlId++;
    }

    public void init(){
        longUrlId = Constants.dbRowId;
        clientDataMap = new HashMap<Integer, UserData>();
        shortToLongUrlMap = new HashMap<String, ShortUrl>();
    }

    public boolean isLongUrlAlreadyPresentForClient(String longUrl, int clientId){

        if(clientDataMap.get(clientId) == null){
            return false;
        }

        if(clientDataMap.get(clientId).longToShortUrlMap.get(longUrl)!=null){
            return true;
        }
        return false;
    }

    public boolean isShortUrlExist(String shortUrl){
        if(shortToLongUrlMap.get(shortUrl)!= null){
            return true;
        }
        return false;
    }

    public ShortUrl getLongUrlForShort(String shortUrl){
        return shortToLongUrlMap.get(shortUrl);
    }

    public String getShortUrlForClient(int clientId, String longUrl){
       return clientDataMap.get(clientId).longToShortUrlMap.get(longUrl);
    }

    public static void saveShortUrlToClientMap(int clientId, String longUrl, String shortUrl){
        UserData data = new UserData(clientId);
        data.longToShortUrlMap.put(longUrl, shortUrl);
        clientDataMap.put(clientId, data);
    }

    public static void saveShortToLongUrlMap(String shortUrl, String longUrl){
        ShortUrl shortUrlObj = new ShortUrl(shortUrl, longUrl);
        shortToLongUrlMap.put(shortUrl, shortUrlObj);
    }

    public void updateShorturlStats(String shortUrl){
        if(!dataManager.isShortUrlExist(shortUrl)){
            return;
        }
        ShortUrl obj = shortToLongUrlMap.get(shortUrl);
        obj.updateHitCount();
        shortToLongUrlMap.put(shortUrl, obj);
//        Constants.print(String.valueOf(shortToLongUrlMap.get(shortUrl).getHitCount()));
    }


}
