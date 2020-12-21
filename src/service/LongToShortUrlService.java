/**
 * @author AbsolutelySaurabh
 */
package service;

import constant.Constants;
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

        char map[] = Constants.map;
        StringBuffer shorturl = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (dbRowId > 0)
        {
            shorturl.append(map[dbRowId % 62]);
            dbRowId = dbRowId / 62;
        }
        Constants.print(shorturl.toString());
        return shorturl.reverse().toString();
    }

    public String getShortenedURL(String longUrl, int clientId){

        if(dataManager.isLongUrlAlreadyPresentForClient(longUrl, clientId)){
            return dataManager.getShortUrlForClient(clientId, longUrl);
        }
        int dbRowId = dataManager.getLongUrlId();
        String shortUrl = computeShortUrl(dbRowId);
        dataManager.saveShortUrlToClientMap(clientId, longUrl, shortUrl);
        dataManager.saveShortToLongUrlMap(shortUrl, longUrl);
        return shortUrl;
    }

    public String getOriginalURL(String shortUrl){
        if(!dataManager.isShortUrlExist(shortUrl)){
            Constants.print("ERROR: Short Url doesn't exist in db");
            return null;
        }
        return dataManager.getLongUrlForShort(shortUrl);
    }

}
