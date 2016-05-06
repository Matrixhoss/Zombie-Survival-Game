
package survivalgame;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JFrame {
    private Zombie z ;
    private MELEE m;
    
    private ImagePanel Background;
    private JPanel test;
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
      ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    
    public Map(){
     
  
    Container c = this.getContentPane();
    
    test=new JPanel();//
    test.setLayout(null);//
    test.setBounds(0,0,400,400);//
   

    
    Background = new ImagePanel(MapIcn.getImage());
    c.add(Background);
    //Background.add(test);
    
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    z= new Zombie(100,200,m,"asd");
    z.setIcon(Zombierawr);
    z.setBounds(50,50, 200, 400);
    Background.add(z);
    
    
    
    }
 }
