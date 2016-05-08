
package survivalgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
    private ZombieGenerator zn;
    private ZombieGenerator zf;
    private Player p ;
    private Weapons w = new Weapons ();
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    ImageIcon Playericon  = new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png"));
    private Random r;
    private Random R;
    private Dimension mapdim = new Dimension();
    public Map(){
 
  
    Container c = this.getContentPane();
    
    Background = new ImagePanel(MapIcn.getImage());
    c.add(Background);
   
       p = new Player (100,10,w,this,20,20);
       p.setIcon(Playericon);
       p.setSize(100, 100);
       Background.add(p);
        mapdim=Background.getSize();
     
   
   try{ 
       r= new Random();
 
    zn=new ZombieGenerator("ZombieNormal");
        for (int i = 0; i < zn.getZombieNumber(); i++) {
              int x = r.nextInt(1400);
              int y= r.nextInt(800);
            zn.z[i].setBounds(x, 780, 100,100);
            Background.add(zn.z[i]);
        }
        zn=new ZombieGenerator("ZombieFast");
        for (int i = 0; i < zn.getZombieNumber(); i++) {
              int x = r.nextInt(1400);
              int y= r.nextInt(800);
            zn.z[i].setBounds(x, 780, 100,100);
            Background.add(zn.z[i]);
        }
   }
   catch(Exception ex){
       System.out.print(ex);
   
   }
    
   
    Timer t=new Timer(30,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < zn.getZombieNumber(); i++)
            zn.z[i].AI(p.getX(),p.getY());
           //z.move();
           p.move(mapdim);
           p.setLocation(p.getx(), p.gety());
        }
   
   
    });
    t.start();
    
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    }
 }
