/**
 * @author AbsolutelySaurabh
 */
package main.service;

import main.constant.Constants;
import main.data.ShortUrl;
import main.datamanager.DataManager;

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
        dataManager.init();
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
//        Constants.print(shorturl.toString());
        return shorturl.reverse().toString();
    }

    public String getShortenedURL(String longUrl, int clientId){

        String shortUrl = null;
        if(dataManager.isLongUrlAlreadyPresentForClient(longUrl, clientId)){
//            Constants.print("LONG URL ALREADY!!");
            shortUrl = dataManager.getShortUrlForClient(clientId, longUrl);
            Constants.print(shortUrl);
            return shortUrl;
        }
        int dbRowId = dataManager.getLongUrlId();
        shortUrl = computeShortUrl(dbRowId);
        dataManager.saveShortUrlToClientMap(clientId, longUrl, shortUrl);
        dataManager.saveShortToLongUrlMap(shortUrl, longUrl);
        dataManager.incrementLongUrlId();

        Constants.print(shortUrl);
        return shortUrl;
    }

    public String getOriginalURL(String shortUrl){
        if(!dataManager.isShortUrlExist(shortUrl)){
            return null;
        }
        ShortUrl shortUrlObj = dataManager.getLongUrlForShort(shortUrl);
        String originalUrl = shortUrlObj.getLongUrl();
        dataManager.updateShorturlStats(shortUrl);
        Constants.print(originalUrl);
        return originalUrl;
    }
}
