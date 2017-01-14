import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel{
    
    GameTextArea text;
    
    public OutputPanel() {
        super();
        int prefHeight = GameConstants.ioHeight;
        int prefWidth = GameConstants.xResolution / 2;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        text = new GameTextArea(GameConstants.outCharHeight, 
                                GameConstants.outCharLength);
        this.add(text);
        
        setBackground(GameConstants.BG_OUT_COLOR);
    }
    
    public void setText(String str) {
        text.setText(str);
    }
}