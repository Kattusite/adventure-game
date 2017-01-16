/*
 * This class contains all of the useful constants and configurables in the
 * program.
 * 
 * 
 * TO ADD: The Font to be used in all GameTextAreas should be stored in this
 * class eventually.
 * 
 * To do: remove extraneous imports from other classes
 * 
 */

import java.awt.Color;

public class GameConstants {
    
    
    
    
    // Letters are 10px wide at 16 pt font
    // So 78 charLength gives 780 pixels. 18 of these are taken away
    // for other purposes, leaving 10 pixels as a border on left and 10 on right
    // it looks like 47 vertical pixels are lost to the toolbar, - [] X, etc.
    
    // Title of the game, that appears in the Task view and on the window
    static final String gameTitle = "Grabthar's Fourth";
    static final String FONT_NAME = "Courier";
    
    static final String newline = System.getProperty("line.separator");
    
    static final String ASCII_PATH = "ascii.txt";
    // used when an ascii image is not properly defined in .txt file
    static final String notFound = "not found"; 
    
    // Constant IDs for gui elements
    // Used as array indexes for calling config data more easily, esp.
    // in GameTextArea and GUIFrame constructors.
    static final int ART = 0;
    static final int IN  = 1;
    static final int INV = 2;
    static final int OUT = 3;
    
    // X and Y pixel counts for the game window
    static final int X_RES = 820; // 18px more than actual usable space
    static final int Y_RES = 657; // 47px more than actual usable space
    
    // Various GUI Element sizes
    static final int[] GUI_WIDTHS = {
        X_RES,     // ART =  X_RES       px wide
        X_RES / 2, //  IN =  X_RES / 2   px wide
        X_RES,     // INV =  X_RES       px wide
        X_RES / 2  // OUT =  X_RES / 2   px wide
    };
    
    static final int[] GUI_HEIGHTS = {
        410, // ART = 410 px tall
        100, //  IN = 100 px tall
        100, // INV = 100 px tall
        100  // OUT = 100 px tall
    };
    
    // Various GameTextArea sizes and char counts.
    // How many characters can fit in the window lengthwise.
    // Used internally only. For external use, read from the guiCharLengths array.
    private static final int windowCharLength = 78; 
    static final int[] GUI_CHAR_LENGTHS = { 
        windowCharLength,     // ART = 78 chars long
        windowCharLength / 2, // IN  = 39 chars long
        windowCharLength,     // INV = 78 chars long
        windowCharLength / 2  // OUT = 39 chars long
    };
        
    // Note: vars aren't listed in the same order as stored in array below!!
    // These are used only internally. For external use, read from the 
    // guiCharHeights array.
    // The private fields exist here only because it is convenient:
    // several of the heights are naturally proportional to one another
    // i.e. private fields can be removed if proportionality no longer needed.
    private static final int artCharHeight = 18;
    private static final int invCharHeight = 4; // note: out of usual order!
    private static final int  inCharHeight = invCharHeight / 2;
    private static final int outCharHeight = invCharHeight;
    static final int[] GUI_CHAR_HEIGHTS = {
        artCharHeight, // ART = 18 chars tall
        inCharHeight,  // IN  =  2 chars tall
        invCharHeight, // INV =  4 chars tall
        outCharHeight  // OUT =  4 chars tall
    };
    
    // Colors used in every GameTextArea for foreground & background
    static final Color BG_TEXT_COLOR = Color.decode("#333333"); // websafe dk grey
    static final Color FG_TEXT_COLOR = Color.decode("#00cc00"); // websafe lt green 
    
    // Background colors used for each element of the GUI.
    static final Color[] BG_COLORS = {
        Color.decode("#6666ff"), // ART = websafe bluish
        Color.decode("#6666cc"), // IN  = websafe bluish
        Color.decode("#9999cc"), // INV = websafe bluish
        Color.decode("#9999cc")  // OUT = websafe bluish
    };
}