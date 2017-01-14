/*
 * This class is a JPanel object that reads in the appropriate sizing and 
 * coloring arguments from GameConstants, and then constructs a JPanel 
 * according to those specifications, containing a GameTextArea
 */

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    
    GameTextArea text;
    
    public GamePanel(int elementID) {
        super();
        int prefHeight = GameConstants.GUI_HEIGHTS[elementID];
        int prefWidth = GameConstants.GUI_WIDTHS[elementID];
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        text = new GameTextArea(GameConstants.GUI_CHAR_HEIGHTS[elementID], 
                                GameConstants.GUI_CHAR_LENGTHS[elementID]);
        
        this.add(text);
        
        setBackground(GameConstants.BG_COLORS[elementID]);
    }
    
    
    // THE METHODS BELOW SHOULD SIMPLY ALIAS METHODS ALREADY IN GameTextArea
    // and do NOTHING MORE.
    
    // SETTER METHOD
    
    // Set the contents of the interior JTextArea to the given String.
    public void setText(String str) {
        text.setText(str);
    }  
    
    public void clear() {
        text.clear();
    }
    
    // PRINTING METHODS
   
    // Prints the given string
    // Print may not work as expected if the text to be printed is too long
    public void print(String str) {
        text.print(str);
    }
    
    public void print(Object obj) {
        text.print(obj);
    }
    
    // Prints the given string, followed by a newline character.
    // Println may not work as expected if the text to be is too long
    public void println(String str) {
        text.println(str);
    }
    
    public void println(Object obj) {
        text.println(obj);
    }
    
    // Prints the given formatted string, according to String.format()
    // may not work as expected if text to be printed is too long
    public void printf(String format, Object... args) {
        text.printf(format, args);
    }
    
    
}