/**
 * @author AbsolutelySaurabh
 */
package data;

import java.util.HashMap;

public class Data {

    public int clientId;
    public HashMap<String, String> longToShortUrlMap;
    
    public Data(int clientId) {
        this.clientId = clientId;
        this.longToShortUrlMap = new HashMap<>();
    }
}
