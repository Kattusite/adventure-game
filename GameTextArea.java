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
 */

import javax.swing.*;
import java.awt.*;

public class GameTextArea extends JScrollPane {
    
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
        
        Font f = new Font("Courier", Font.PLAIN, 16);
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
    
    // PRINTING METHODS
    
    // Prints the given string
    // Print may not work as expected if the text to be printed > lineLength
    public void print(String str) {
        text.append(str);
    }
    
    // Prints the given object by invoking toString()
    public void print(Object obj) {
        print(obj.toString());
    }
    
    // Prints the given string, followed by a newline character.
    // Println may not work as expected if the text to be printed > lineLength
    public void println(String str) {
        print(str + "\n");
    }
    
    // Prints the given object by invoking toString(), then a newline.
    public void println(Object obj) {
        print(obj);
        print("\n");
    }
    
    // Prints the given formatted string, according to String.format()
    // may not work as expected if text to be printed > lineLength
    public void printf(String format, Object... args) {
        print(String.format(format, args));
    }
}