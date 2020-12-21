/**
 * @author AbsolutelySaurabh
 */
package main.data;

import java.util.HashMap;

public class UserData {

    public int clientId;
    public HashMap<String, String> longToShortUrlMap;
    
    public UserData(int clientId) {
        this.clientId = clientId;
        this.longToShortUrlMap = new HashMap<>();
    }
}
