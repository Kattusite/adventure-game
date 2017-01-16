/*
 * This class is responsible for facilitating requests for ascii art.
 * 
 * It is given item names and provides the caller with the relevant ascii 
 * art, if it could be found.
 * 
 * If it cannot be found, it provides a default ascii art.
 * 
 */
import java.util.HashMap;
public class ASCIIManager {
 
    static HashMap<String, String[]> asciiMap;
    
    static {
        ASCIIReader ar = new ASCIIReader(GameConstants.ASCII_PATH);
        asciiMap = ar.getMap();
    }
    
    static String[] get(String key) {
        String[] value = asciiMap.get(key);
        if (value == null) { // not found in the map
            value = asciiMap.get(GameConstants.notFound);
        }
        return value;
    }
}