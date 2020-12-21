import constant.Constants;
import service.LongToShortUrlService;

import java.util.Scanner;

/**
 * @author AbsolutelySaurabh
 */

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Constants.print("PRESS   1. Input   |    -1. Exit");
        int key = s.nextInt();
        LongToShortUrlService service = LongToShortUrlService.getInstance();
        service.init();

        while(key == -1){

            int apiNo = s.nextInt();
            if(apiNo == 1){

                s.nextLine();
                Constants.print("Enter Long Url: ");
                String longUrl = s.nextLine();
                int clientId = s.nextInt();
                Constants.print("longUrl: " + longUrl + " clientId: " + clientId);
                Constants.print("shortedned url:"  + service.getShortenedURL(longUrl, clientId));
            }else{

                s.nextLine();
                Constants.print("Enter Short Url: ");
                String shortUrl = s.nextLine();
                Constants.print("shortUrl: " + shortUrl);
                Constants.print("Original url:"  + service.getOriginalURL(shortUrl));

            }
            key = s.nextInt();
        }
    }

}
