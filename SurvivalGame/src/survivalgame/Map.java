
package survivalgame;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Map extends JFrame {
    
    private ImagePanel Background;
    
    public Map(){
        
     Background = new ImagePanel(new ImageIcon("misc/Map.jpg").getImage());
    Container c = this.getContentPane();
    c.add(Background);
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    
    
    
    }
    
  
}
