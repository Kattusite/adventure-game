import javax.swing.*;
import java.awt.*;
public class GUIFrame extends JFrame {
    
    ArtPanel artPanel;
    InventoryPanel inventoryPanel;
    InputPanel inputPanel;
    OutputPanel outputPanel;
    
    JPanel verticalPanel;
    JPanel ioPanel;
    
    static final int X_AXIS = BoxLayout.X_AXIS;
    static final int Y_AXIS = BoxLayout.Y_AXIS;
    
    public GUIFrame() {
        // Initialize basic components
        super(GameConstants.gameTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GameConstants.xResolution, GameConstants.yResolution);
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        
        // Initialize Panels
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, Y_AXIS));
        
        ioPanel = new JPanel();
        ioPanel.setLayout(new BoxLayout(ioPanel, X_AXIS));
        
        // Initialize Panels
        artPanel = new ArtPanel();
        inventoryPanel = new InventoryPanel();
        inputPanel = new InputPanel();
        outputPanel = new OutputPanel();
        
                          
        // Add content panels to helper panels
        ioPanel.add(inputPanel);
        ioPanel.add(outputPanel);
                          
        verticalPanel.add(artPanel);
        verticalPanel.add(inventoryPanel);
        verticalPanel.add(ioPanel);
                 
                 
        // Add helper panels to  top level Frame                  
        this.add(verticalPanel);
        this.add(ioPanel);
        
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        GUIFrame gui = new GUIFrame();
    }
    
}
    
    