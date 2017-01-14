import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel{
    
    public InputPanel() {
        super();
        int prefHeight = GameConstants.ioHeight;
        int prefWidth = GameConstants.xResolution / 2;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        setBackground(Color.GREEN);
    }
}