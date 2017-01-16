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

public class GameTextArea extends JScrollPane {
    
    private static final String newline = GameConstants.newline;
    
    // I only need these if I get around to enforcing scrolling / line length
    private int lineLength;
    private int numLines;
    JTextArea text; // text area contained within, responsible for holding data
    
    // Constructor
    public GameTextArea(int cols, int rows) {
        super();
        
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