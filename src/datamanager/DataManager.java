package datamanager; /**
 * @author AbsolutelySaurabh
 */

import constant.Constants;
import data.Data;

import java.util.HashMap;

public class DataManager {

    private static DataManager dataManager;
    public static HashMap<String, Data> clientDataMap;
    public static HashMap<String, String> shortToLongUrlMap;
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

    private void init(){
        longUrlId = Constants.dbRowId;
        clientDataMap = new HashMap<String, Data>();
        shortToLongUrlMap = new HashMap<String, String>();
    }

    public boolean isLongUrlAlreadyPresentForClient(String longUrl, String clientId){
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

    public String getLongUrlForShort(String shortUrl){
        return shortToLongUrlMap.get(shortUrl);
    }

    public String getShortUrlForClient(String clientId, String longUrl){
       return clientDataMap.get(clientId).longToShortUrlMap.get(longUrl);
    }

    public static void saveShortUrlToClientMap(String clientId, String longUrl, String shortUrl){
        Data data = new Data(clientId);
        data.longToShortUrlMap.put(longUrl, shortUrl);
        clientDataMap.put(clientId, data);
    }

    public static void saveShortToLongUrlMap(String shortUrl, String longUrl){
        shortToLongUrlMap.put(shortUrl, longUrl);
    }

}
