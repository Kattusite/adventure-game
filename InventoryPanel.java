import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel{
    
    GameTextArea text;
    
    public InventoryPanel() {
        super();
        int prefHeight = GameConstants.invHeight;
        int prefWidth = GameConstants.xResolution;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        text = new GameTextArea(GameConstants.invCharHeight, 
                                 GameConstants.invCharLength);
        add(text);
        
        setBackground(GameConstants.BG_INV_COLOR);
        
        
    }
    public void setText(String str) {
        text.setText(str);
    }
}