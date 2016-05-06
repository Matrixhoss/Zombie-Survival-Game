
package survivalgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JFrame {
    private ZombieNormal z ;
    private ImagePanel Background;
    private ZombieGenerator zg;
    private Player p ;
    private Weapons w = new Weapons ();
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    ImageIcon Playericon  = new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png"));
    private Random r;
    private Random R;
    public Map(){
 
  
    Container c = this.getContentPane();
    
    Background = new ImagePanel(MapIcn.getImage());
    c.add(Background);
    
       p = new Player (100,10,w,this,50,50);
       p.setIcon(Playericon);
       p.setSize(200, 200);
       Background.add(p);
       
     
   
   try{ 
       r= new Random();
 
    zg=new ZombieGenerator("ZombieNormal");
        for (int i = 0; i < zg.getZombieNumber(); i++) {
              int x = r.nextInt(1400);
              int y= r.nextInt(800);
            zg.z[i].setBounds(x, 780, 100,100);
            Background.add(zg.z[i]);
        }
   }
   catch(Exception ex){
       System.out.print(ex);
   
   }
    
   
    Timer t=new Timer(50,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        
           z.move();
           p.move();
           p.setLocation(p.getx()*p.getSpeed(), p.gety()*p.getSpeed());
        }
   
   
    });
    t.start();
    
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    }
 }
