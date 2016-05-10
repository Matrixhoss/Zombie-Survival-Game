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
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import static survivalgame.main_menu.x;

public class Map extends JFrame {
    private Random zm_sound;
    private ZombieNormal z ;
    private ImagePanel Background;
    private ZombieGenerator zn;
    private ZombieGenerator zf;
    private Player p ;
    private Random r;
    private Random R;
    private Dimension mapdim = new Dimension();
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    ImageIcon Playericon  = new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png"));

    private Container c;
     
    private int TotalNumberOfZombies;
    public Map(){
    
    c = this.getContentPane();
    
    setBackground(MapIcn);
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
            zn.z.get(i).rotation();
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
    Map.playback1();
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
      public void setBackground(ImageIcon IC){
      
      Background = Background = new ImagePanel(IC.getImage());
      c.add(Background);
      mapdim=Background.getSize();
      
      Random zm_Random = new Random();
      }
      public static void playback1(){
          try{
        //      int sound= ();
         //     switch()
                File file = new File("sprint0.wav");
                Clip clip1 = AudioSystem.getClip();
                clip1.open(AudioSystem.getAudioInputStream(file));
                clip1.loop(Clip.LOOP_CONTINUOUSLY);
                clip1.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
}