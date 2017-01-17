/*
 * This class is a specialized JTextArea that is wrapped in a JScrollPane
 * and customized according to the required specifications.
 * 
 * It uses a monospace font
 * 
 * Simply put, it's a text box.
 * 
 * TO DO: Add enforcement of number of rows
 * Although this class is technically wrapped in a JScrollPane
 * we do not actually want to make use of the scrolling function.
 * 
 * Alternatively, suppress vertical scrollbar with:
 * setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
 * 
 * TO DO: setEditable(false)
 * 
 * TO DO: Define an interface for this and GamePanel to share.
 * 
 * TO DO: Ensure newline characters are system independent.
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;

public class GameTextArea extends JScrollPane {
    
    private static final String newline = GameConstants.newline;
    private static final String emptyString = "";
    private static final String space = " ";
    
    // I only need these if I get around to enforcing scrolling / line length
    private int lineLength;
    private int numLines;
    JTextArea text; // text area contained within, responsible for holding data
    
    // Constructor
    public GameTextArea(int cols, int rows) {
        super();
        
        // suppress the scroll bar from appearing.
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        // initialize row, col variables
        lineLength = rows;
        numLines = cols;
        
        // Set up the interior JTextArea contained within (fonts, colors)
        text = new JTextArea(cols, rows);
        text.setLineWrap(true);
        
        text.setBackground(GameConstants.BG_TEXT_COLOR);
        text.setForeground(GameConstants.FG_TEXT_COLOR);
        
        Font f = new Font(GameConstants.FONT_NAME, Font.PLAIN, 16);
        text.setFont(f);
        
        // Wrap the JTextArea inside a JScrollPane
        setViewportView(text);
    }
    
    // GENERAL METHODS
    
    // Set the contents of the interior JTextArea to the given String.
    public void setText(String str) {
        text.setText(str);
    }  
    
    // Sets the contents of the interior JTextArea to the given ArrayList, 
    // line by line. 
    private void setText(ArrayList<String> lineList) {
        clear();
        for (String currentLine : lineList) {
            println(currentLine);
        }
    }
    
    // Clears all text from the interior JTextArea
    public void clear() {
        text.setText("");
    }
    
    // Does nothing for the specified number of ms.
    private void wait(int ms) {
        long start = System.currentTimeMillis();
        long end = start + ms;
        while(System.currentTimeMillis() < end) {
            // just do nothing. this should prob. be replaced with
            // Thread.sleep() or similar
        }
    }
    
    // DISPLAY METHODS 
    
    // Animates a given set of frames, waiting ms between frames
    // Clears the textArea completely between frames.
    public void animate(String[] frames, int ms) {
        for (int k = 0; k < frames.length; k++) {
            clear();
            print(frames[k]);
            wait(ms);
        }
    }
    
    // Types a given message 1 character at a time until the message is 
    // complete, with a delay of ms between characters.
    public void type(String str, int ms) {
        char[] characters = str.toCharArray();
        for (char c : characters) {
            print(c);
            wait(ms);
        }
    }
    
    // Print the given ascii image at the given coordinates, overwriting
    // any text currently occupying that location, and adding spaces before
    // if needed. 
    
    // NOTE: x, y coordinate system starts with 0, 0 at top left corner of 
    // ALL TEXT printed to the JTextArea 
    // (the y-direction extends downward for an arbitrary distance.) 
    // x direction is capped at the end of the line. 
    
    // scrolling behavior of text may not be as expected, esp. if ascii does not
    // fit in the visible space
    
    // the argument preserveWhitespace is slightly misnamed:
    // it optionally will not overwrite an existing character with " ".
    
    // This method isn't terribly efficient. Should probably be revised heavily
    public void displayASCII(int startX, int startY, String[] ascii,
                             boolean preserveWhitespace) {
        if (startX < 0 || startY < 0) {
            throw new IndexOutOfBoundsException("startX: " + startX + ", " + 
                                                "startY: " + startY);
        }
        int endY = startY + ascii.length;
        
        String[] arr = text.getText().split(GameConstants.newline);
        ArrayList<String> lineList = new ArrayList<String>(Arrays.asList(arr));
        // line array arr is not needed any longer
        arr = null;
        
        int textMaxY = lineList.size();
        
        // Print the ascii row by row.
        for (int y = 0; y < endY; y++) {
            // If moving to a line with no text at all on it, create a line
            if (y >= textMaxY) {
                lineList.add(emptyString); // equals ""
            }
            // If some of the image falls on this row, print that part.
            if (y >= startY) {
                StringBuilder currentLine = new StringBuilder(lineList.get(y));
                // Calculate index of the line of ascii array to print
                int asciiIndexY = y - startY;
                String currentLineASCII = ascii[asciiIndexY];
                // Find out first x index that will not need to be printed
                int endX = startX + currentLineASCII.length();
                // find out how many characters already exist on this line
                int lineMaxX = currentLine.length();
                for (int x = 0; x < endX; x++) {
                    int asciiIndexX = x - startX;
                    
                    // If this position on the line is newly visited add " "
                    if (x >= lineMaxX) {
                        // THIS IS WHERE I SHOULD ADD A CHECK FOR EXCEEDING
                        // THE JTEXTAREA's PREDEFINED LINE LENGTH
                        currentLine.append(space);
                    }
                    // If this position is included in the ascii print, 
                    // replace current char with new ascii character
                    if (x >= startX) {
                        String letter = "" + currentLineASCII.charAt(asciiIndexX);
                        // if !preserveWhitespace and letter is space, ignore it
                        if (preserveWhitespace || !letter.equals(space)) {
                            currentLine.replace(x, x+1, letter);
                        }
                    }
                }
                // Line has been fully processed. 
                // Replace the old current line with the new current line
                // in lineList.
                lineList.set(y, currentLine.toString());
            }
            
        }
        // All lines have finished printing. 
        // Update the contents of the JTextArea with the newly created
        // ArrayList<String>
        setText(lineList);
    }
    
    
    // PRINTING METHODS
    
    // Prints the given string
    // Print may not work as expected if the text to be printed > lineLength
    // ALL OTHER PRINTING METHODS DEPEND UPON THIS ONE.
    public void print(String str) {
        text.append(str);
    }
    
    // Prints the given object by invoking toString()
    public void print(Object obj) {
        print(obj.toString());
    }
    
    // Prints the given string, followed by a newline character
    public void println(String str) {
        print(str);
        println();
    }
    
    // Prints the given object by invoking toString(), then a newline.
    public void println(Object obj) {
        print(obj);
        println();
    }
    
    //Prints a single newline character 
    public void println() {
        print(newline);
    }
    
    // Prints the given formatted string, according to String.format()
    public void printf(String format, Object... args) {
        print(String.format(format, args));
    }
}