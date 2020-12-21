/**
 * @author AbsolutelySaurabh
 */
package datamanager;

import data.Data;

import java.util.HashMap;

public class DataManager {

    private static DataManager dataManager;
    public static HashMap<String, Data> clientDataMap;
    public static HashMap<String, String> shorttoLongUrlMap;
    private static int longUrlId;

    public static DataManager getInstance(){
        if(dataManager == null){
            init();
        }
        return dataManager;
    }

    private static void init(){
        longUrlId = 1234;
        dataManager = new DataManager();
        clientDataMap = new HashMap<String, Data>();
        shorttoLongUrlMap = new HashMap<String, String>();
    }

    public boolean isLongUrlAlreadyPresentForClient(String longUrl){
        if(clientDataMap.get(longUrl)!=null){
            return true;
        }
        return false;
    }

    public String getShortUrlForClient(String clientId, String longUrl){
       return clientDataMap.get(clientId).longToShortUrlMap.get(longUrl);
    }

    public static void saveShortUrlToClient(String clientId, String longUrl, String shortUrl){
        Data data = new Data(clientId);
        data.longToShortUrlMap.put(longUrl, shortUrl);
        clientDataMap.put(clientId, data);
    }

}
