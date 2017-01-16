/*
 * 
 * 
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class ASCIIReader {
    
    final static String encoding = "utf-8";
    // regexp for finding strings preceded by "#name:"
    // consisting of any number of any character (including whitespace)
    // and followed by "#end"
    //  "(?<=#item:)[\\S\\s]*?(?=#end)"
    final static String startKeyword = "#item:";
    final static String startRegexp = startKeyword + ".*";
    final static String endRegexp = "#end";
    Scanner input;
    HashMap<String, String[]> map;
    
    public ASCIIReader(String filename) {
        try {
            input = new Scanner(new File(filename), encoding);
        } catch (FileNotFoundException err) {
            System.err.println("Error: File " + filename + " not found!");
            err.printStackTrace();
        }
        map = new HashMap<String, String[]>();

        boolean readingData = false;

        String itemName ="NONAME";
        LinkedList<String> asciiBuilder = new LinkedList<String>();
        
        while(input.hasNextLine()) {
            // Read in a line from input file
            String current = input.nextLine();
            
            // if at the end of a definition
            if (current.matches(endRegexp)) {
                // Send the collected key/value pair to the HashMap
                String[] ascii = asciiBuilder.toArray(new String[0]);
                map.put(itemName, ascii);
                    
                // stop reading data for this entry, and reinitialize variables
                readingData = false;
                itemName = "NONAME";
                asciiBuilder = new LinkedList<String>();
            }
            
            // if in the middle of a definition
            if (readingData) {
                asciiBuilder.add(current);
            }
            
            // If at the start of a definition:
            if (current.matches(startRegexp)) {
                readingData = true; // begin reading data
                // record the item name from the same line
                itemName = current.replace(startKeyword, "").trim();
                // if the name wasn't defined properly in input, throw error
                if ("".equals(itemName) || itemName == null) {
                    throw new RuntimeException("The ascii input file is " + 
                                               "not formatted properly.");
                }
            }
        }
    }
    
    public HashMap<String, String[]> getMap() {
        return map;
    }
    
    public String[] get(String key) {
        return map.get(key);
    }
}