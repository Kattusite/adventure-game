import java.awt.Color;

public class GameConstants {
    
    
    // Letters are 10px wide at 16 pt font
    // So 78 charLength gives 780 pixels. 18 of these are taken away
    // for other purposes, leaving 10 pixels as a border on left and 10 on right
    // it looks like 47 vertical pixels are lost to the toolbar, - [] X, etc.
    
    // Title of the game, that appears in the Task view and on the window
    static final String gameTitle = "Grabthar's Fourth";
    
    // X and Y pixel counts for the game window
    static final int xResolution = 820; // 18px more than actual usable space
    static final int yResolution = 657; // 47px more than actual usable space
    
    // Various GUI Element sizes
    static final int ioHeight =  100;
    static final int artHeight = 410;
    static final int invHeight = 100;
    
    // Various GameTextArea sizes and char counts.
    static final int artCharLength = 78;
    static final int artCharHeight = 18;
    
    static final int invCharLength = artCharLength;
    static final int invCharHeight = 4;
    
    static final int inCharLength  = artCharLength / 2;
    static final int inCharHeight  = invCharHeight / 2;
    
    static final int outCharLength = artCharLength / 2;
    static final int outCharHeight = invCharHeight;
    
    // Colors used in the game
    static final Color BG_TEXT_COLOR = Color.decode("#333333"); // websafe dk grey
    static final Color FG_TEXT_COLOR = Color.decode("#00cc00"); // websafe lt green
    
    static final Color BG_IN_COLOR  = Color.decode("#6666ff"); // websafe bluish
    static final Color BG_OUT_COLOR = Color.decode("#6666cc"); // websafe bluish
    static final Color BG_INV_COLOR = Color.decode("#9999cc"); // websafe bluish
    static final Color BG_ART_COLOR = Color.decode("#9999ff"); // websafe bluish
   
}