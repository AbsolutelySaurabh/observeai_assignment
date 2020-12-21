package main.datamanager; /**
 * @author AbsolutelySaurabh
 */

import main.constant.Constants;
import main.data.Data;

import java.util.HashMap;

public class DataManager {

    private static DataManager dataManager;
    public static HashMap<Integer, Data> clientDataMap;
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

    public void init(){
        longUrlId = Constants.dbRowId;
        clientDataMap = new HashMap<Integer, Data>();
        shortToLongUrlMap = new HashMap<String, String>();
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

    public String getLongUrlForShort(String shortUrl){
        return shortToLongUrlMap.get(shortUrl);
    }

    public String getShortUrlForClient(int clientId, String longUrl){
       return clientDataMap.get(clientId).longToShortUrlMap.get(longUrl);
    }

    public static void saveShortUrlToClientMap(int clientId, String longUrl, String shortUrl){
        Data data = new Data(clientId);
        data.longToShortUrlMap.put(longUrl, shortUrl);
        clientDataMap.put(clientId, data);
    }

    public static void saveShortToLongUrlMap(String shortUrl, String longUrl){
        shortToLongUrlMap.put(shortUrl, longUrl);
    }

}
