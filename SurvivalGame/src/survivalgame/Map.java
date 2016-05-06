
package survivalgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JFrame {
    private ZombieNormal z ;
    private ImagePanel Background;
    private ZombieGenerator zg;
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    private Random r;
    private Random R;
    public Map(){
 
  
    Container c = this.getContentPane();
    
    Background = new ImagePanel(MapIcn.getImage());
    c.add(Background);
     
   
   try{ 
       r= new Random();
 
    zg=new ZombieGenerator("ZombieNormal");
        for (int i = 0; i < zg.getZombieNumber(); i++) {
              int x = r.nextInt(1400);
              int y= r.nextInt(800);
            zg.z[i].setBounds(0, y, 100,100);
            Background.add(zg.z[i]);
        }
   }
   catch(Exception ex){
       System.out.print(ex);
   
   }
    
    z= new ZombieNormal();
    z.setIcon(Zombierawr);
    z.setBounds(50,50, 100, 100);
    Background.add(z);
    Timer t=new Timer(50,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        
           z.move();
           
        }
   
   
    });
    t.start();
    
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    }
 }
