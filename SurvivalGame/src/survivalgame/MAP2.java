
package survivalgame;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MAP2 extends JFrame {
    private Zombie z ;
    private ImagePanel Background;
    
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/dre.png"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    
    public MAP2(){
        
    Container c = this.getContentPane();
    
    Background = new ImagePanel(MapIcn.getImage());
    c.add(Background);
     
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
//    
//    z= new Zombie(100,200,"asd");
//    z.setIcon(Zombierawr);
//    z.setBounds(50,50, 200, 400);
//    Background.add(z);
    
    }
 }