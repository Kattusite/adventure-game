import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel{
    
    public OutputPanel() {
        super();
        int prefHeight = GameConstants.ioHeight;
        int prefWidth = GameConstants.xResolution / 2;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        setBackground(Color.CYAN);
    }
}