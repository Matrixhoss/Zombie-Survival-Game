
package survivalgame;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Map extends JFrame {
    private Zombie z ;
    private ImagePanel Background;
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    public Map(){
     
     Background = new ImagePanel(MapIcn.getImage());
    Container c = this.getContentPane();
    
    c.add(Background);
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    
    
    }
 }
