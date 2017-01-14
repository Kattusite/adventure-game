import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel{
    
    public InventoryPanel() {
        super();
        int prefHeight = GameConstants.invHeight;
        int prefWidth = GameConstants.xResolution;
        Dimension prefDims = new Dimension(prefWidth, prefHeight);
        setPreferredSize(prefDims);
        setMaximumSize(prefDims);
        
        setBackground(Color.RED);
    }
}