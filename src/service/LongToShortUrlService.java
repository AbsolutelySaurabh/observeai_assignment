/**
 * @author AbsolutelySaurabh
 */
package service;

import datamanager.DataManager;

public class LongToShortUrlService {

    private static LongToShortUrlService service;
    private DataManager dataManager;

    public static LongToShortUrlService getInstance(){

        if(service == null){
            service = new LongToShortUrlService();
        }
        return service;
    }

    public void init(){
        dataManager = DataManager.getInstance();
    }

    private String computeShortUrl(int dbRowId){
        return null;
    }

    public String convertLongtoShortUrl(String longUrl, String clientId){

        if(dataManager.isLongUrlAlreadyPresentForClient(longUrl, clientId)){
            return dataManager.getShortUrlForClient(clientId, longUrl);
        }
        int dbRowId = dataManager.getLongUrlId();
        String shortUrl = computeShortUrl(dbRowId);
        dataManager.saveShortUrlToClient(clientId, longUrl, shortUrl);
        return shortUrl;
    }

}
