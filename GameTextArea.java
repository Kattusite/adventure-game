import javax.swing.*;
import java.awt.*;
public class GameTextArea extends JScrollPane {
    
    JTextArea text; // text area contained within, responsible for holding data
    public GameTextArea(int columns, int rows) {
        super();
        
        // Set up the interior JTextArea contained within (fonts, colors)
        text = new JTextArea(columns, rows);
        text.setLineWrap(true);
        
        text.setBackground(GameConstants.BG_TEXT_COLOR);
        text.setForeground(GameConstants.FG_TEXT_COLOR);
        
        Font f = new Font("Courier", Font.PLAIN, 16);
        text.setFont(f);
        
        // Wrap the JTextArea inside a JScrollPane
        setViewportView(text);
    }
    
    // Set the contents of the interior JTextArea to the given String.
    public void setText(String str) {
        text.setText(str);
    }
}