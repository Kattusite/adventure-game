import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel{
    
    GameTextArea text;
    public InputPanel() {
        super();
        int prefHeight = GameConstants.ioHeight;
        int prefWidth = GameConstants.xResolution / 2;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        text = new GameTextArea(GameConstants.inCharHeight, 
                                GameConstants.inCharLength);
        this.add(text); 
        
        setBackground(GameConstants.BG_IN_COLOR);
        
        
    }
    
    private void setText(String str) {
        text.setText(str);
    }
}