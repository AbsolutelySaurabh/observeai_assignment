/**
 * @author AbsolutelySaurabh
 */
package data;

import java.util.HashMap;

public class Data {

    public String clientId;
    public HashMap<String, String> longToShortUrlMap;
    
    public Data(String clientId) {
        this.clientId = clientId;
        this.longToShortUrlMap = new HashMap<>();
    }
}
