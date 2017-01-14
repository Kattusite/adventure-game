import javax.swing.*;
import java.awt.*;
public class GUIFrame extends JFrame {
    
    ArtFrame artFrame;
    InventoryFrame inventoryFrame;
    InputFrame inputFrame;
    OutputFrame outputFrame;
    
    public GUIFrame() {
        // Initialize basic components
        super(GameConstants.gameTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GameConstants.xResolution, GameConstants.yResolution);
        
        this.setLayout(new FlowObject());
        
        // Initialize Frames
        artFrame = new ArtFrame();
        inventoryFrame = new InventoryFrame();
        inputFrame = new InputFrame();
        outputFrame = new OutputFrame();
        
                 
                 
        
        
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        GUIFrame gui = new GUIFrame();
    }
    
}
    
    
