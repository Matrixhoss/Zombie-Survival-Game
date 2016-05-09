
package survivalgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
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
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    ImageIcon Playericon  = new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png"));
    private Random r;
    private Random R;
    private Dimension mapdim = new Dimension();
     public static ArrayList<Zombie>AllZombies=new ArrayList<Zombie>();
     
    private int TotalNumberOfZombies;
    public Map(){
    
    Container c = this.getContentPane();
    
    Background = new ImagePanel(MapIcn.getImage());
    c.add(Background);
    mapdim=Background.getSize();
       
        
     
   
   
       r= new Random();
    
       
      zn=new ZombieGenerator();
      GenerateZombie(zn);
      
    
    
 

    
        
 
   
    p = new Player (100,10,this,20,20,Background,mapdim,zn);
     p.setIcon(Playericon);
       p.setSize(100, 100);
       Background.add(p);
       
   
    Timer t=new Timer(30,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < zn.z.size(); i++){
            zn.z.get(i).AI(p.getX(),p.getY());
//            zn.z.get(i).rotation();
        }
        
        if (zn.z.isEmpty()){
            Waves.setNextWave();
            zn.updateZombie();
            GenerateZombie(zn);
           
        }
           //z.move();
           p.move(mapdim);
           p.animation();
           p.FireHandling();
           
           p.setLocation(p.getx(), p.gety());
           System.out.println(Waves.getWave());
           repaint();
        }
        
        
   
   
    });
    t.start();
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(1280, 720);
    }
       public void GenerateZombie(ZombieGenerator zn){

        for (int i = 0; i < zn.getZombieNumber(); i++) {
              int x = r.nextInt(1280);
              int y= r.nextInt(720);
              int loc=r.nextInt(4);
              
                  switch (loc){
                      case 0: zn.z.get(i).setBounds(x, 780, 100,100);
                              break;
                      case 1:zn.z.get(i).setBounds(0, y, 100,100);
                              break;
                      case 2 :zn.z.get(i).setBounds(x, 0, 100,100);
                              break;
                      case 3: zn.z.get(i).setBounds(1200, y, 100,100);
                              break;
                  }
                 
            Background.add(zn.z.get(i));
        }}
      
    
      
 }
