import javax.swing.*;
import java.awt.*;

public class ArtPanel extends JPanel{
    
    public ArtPanel() {
        super();
        int prefHeight = GameConstants.artHeight;
        int prefWidth = GameConstants.xResolution;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        setBackground(Color.YELLOW);
    }
}