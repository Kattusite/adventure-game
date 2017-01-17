import javax.swing.*;
import java.awt.*;

public class ArtPanel extends JPanel{
    
    GameTextArea text;
    
    public ArtPanel() {
        super();
        int prefHeight = GameConstants.artHeight;
        int prefWidth = GameConstants.artWidth;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        text = new GameTextArea(GameConstants.artCharHeight, 
                                GameConstants.artCharLength);
        
        this.add(text);
        
        setBackground(GameConstants.BG_ART_COLOR);
    }
    
    public void setText(String str) {
        text.setText(str);
    }
    
    
    
}