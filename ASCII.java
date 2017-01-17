/*
 * Maintains a list of all item names and their ASCII art representations
 * 
 * NOTE: Care has not yet been taken to ensure that itemNames and itemASCII
 * remain consistent and synced up with each other.
 * 
 * When adding a new item you must:
 *     * add the item name to the itemnames array
 *     * add the item ascii art as a static string[] 
 *                (change to a text file later?)
 *     * add a reference to ascii art to the itemASCII array
 * 
 */
import java.util.HashMap;

public class ASCII {
    
    static HashMap<String, String[]> map = new HashMap<String, String[]>();
    
    // THE FOLLOWING ARRAYS MUST BE KEPT CONSISTENT.
    static String[] itemNames;    // Array of all item names
    static String[][] itemASCII; // Array of all item asciis
    
    
    // ASCII ART
    static final String[] WOOD_SWORD = {
        "        ",
        "  ,     ",
        "-{====> ",
        "  '     "
    };
    
    static final String[] STEEL_SWORD = {
        " ?  ",
        " ?  ",
        " ?  ",
        " ?  "
    };
    
    static {
        itemNames = new String[]{
            "wood sword", 
            "steel sword"
        };
        
        itemASCII = new String[][]{
            WOOD_SWORD, 
            STEEL_SWORD
        };
        
        // For each item name given, add it to the map as a key
        // with the corresponding ascii art as a value.
        for (int k = 0; k < itemNames.length; k++) {
            map.put(itemNames[k], itemASCII[k]);
        }
        
    }
        
    static String[] lookup(String name) {
        return map.get(name);
    }
    
    
        
}