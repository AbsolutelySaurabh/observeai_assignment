/**
 * @author AbsolutelySaurabh
 */
package main.data;

public class ShortUrl {

    private int hitCount;
    private String shortUrl;
    private String longUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public int getHitCount() {
        return hitCount;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public ShortUrl(String shortUrl, String longUrl){
        this.hitCount = 0;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }
    public void updateHitCount(){
        this.hitCount++;
    }

}
