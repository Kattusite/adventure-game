import javax.swing.*;
import java.awt.*;
public class GUIFrame extends JFrame {
    
    GamePanel art; // contains the ascii battle animations
    GamePanel inv; // contains player inventory
    GamePanel  in; // contains user console
    GamePanel out; // contains HUD data (hp, etc);
    
    private JPanel verticalPanel; // contains art, inv, ioPanel
    private JPanel ioPanel; // contains in, out
    
    // For convenience only, these aliases:
    static final int X_AXIS = BoxLayout.X_AXIS;
    static final int Y_AXIS = BoxLayout.Y_AXIS;
    
    public GUIFrame() {
        // Initialize basic settings for the frame.
        super(GameConstants.gameTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GameConstants.X_RES, GameConstants.Y_RES);
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        
        // Initialize Organizational Panels
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, Y_AXIS));
        
        ioPanel = new JPanel();
        ioPanel.setLayout(new BoxLayout(ioPanel, X_AXIS));
        
        // Initialize Content GamePanels
        art = new GamePanel(GameConstants.ART);
        inv = new GamePanel(GameConstants.INV);
        in  = new GamePanel(GameConstants.IN);
        out = new GamePanel(GameConstants.OUT);
        
                          
        // Add content panels to helper panels
        ioPanel.add(in);
        ioPanel.add(out);
                          
        verticalPanel.add(art);
        verticalPanel.add(inv);
        verticalPanel.add(ioPanel);
                 
                 
        // Add helper panels to  top level Frame                  
        this.add(verticalPanel);
        this.add(ioPanel);
        
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        GUIFrame gui = new GUIFrame();
        gui.art.println("Visible content area: " + 
                        gui.getContentPane().getSize().toString() + "\n");
        gui.art.println("Art panel:");
        gui.art.println(gui.art.getSize());
        
        gui.inv.println("Inv panel");
        gui.inv.println(gui.inv.getSize());
        
        gui.in.println("In panel");
        gui.in.println(gui.in.getSize());
        
        gui.out.println("Out panel");
        gui.out.println(gui.out.getSize());
        
        int numFrames = 200;
        String[] frames = new String[numFrames];
        StringBuilder sb = new StringBuilder("(*_*)");
        for (int k = 0; k < numFrames; k++) {
            frames[k] = sb.toString();
            sb.insert(0, " ");
        }
        gui.art.animate(frames, 20);
        gui.inv.print("\ng2g fast"); 
        
        gui.art.println();
        gui.art.type("It was the best of times, it was the worst of times.", 100);
    }
    
}
    
    