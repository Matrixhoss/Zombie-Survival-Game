package survivalgame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
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
    private JLabel WaveTxt;
    private JLabel WavePopUp;
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
      zn=new ZombieGenerator(Background);
      GenerateZombie(zn);
      p = new Player (100,10,this,20,20,Background,mapdim,zn);
      p.setIcon(Playericon);
      p.setSize(100, 100);
      Background.add(p);
    Timer t2=new Timer(3000,new ActionListener(){
    public void actionPerformed(ActionEvent e){
        WavePopUp.setVisible(false);
        
        if (zn.z.isEmpty()){
           
            Waves.setNextWave();
            WaveTxt.setText("Wave: "+Waves.getWave());
            zn.updateZombie();
            GenerateZombie(zn); 
            
        }
        
        }});
    
    Timer t=new Timer(30,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < zn.z.size(); i++){
            zn.z.get(i).AI(p.getX(),p.getY());
            zn.z.get(i).rotation();
        }
        if (zn.z.isEmpty()){
           
//            WaveTxt.setText("Waves:"+Waves.getWave());
            WavePopUp.setVisible(true); 
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
    
      WaveTxt=new JLabel("Wave: "+Waves.getWave());
      WaveTxt.setBounds(0, 0, 100, 60);
      Background.add(WaveTxt);
      WaveTxt.setFont(new Font("Stencil Regular", Font.BOLD, 20));
      
      WavePopUp=new JLabel("Wave Clear ");
      WavePopUp.setBounds(400,100, 1000,400);
      WavePopUp.setFont(new Font("Stencil Regular", Font.BOLD, 100));
      WavePopUp.setForeground(Color.RED);
        
      WavePopUp.setVisible(false);
      Background.add(WavePopUp);
     
      
    t.start();
    t2.start();
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(1280, 720);
    zomsound();
    Timer ts=new Timer(8000,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            zomsound();
        }
    });
    ts.start();
    }
    public void GenerateZombie(ZombieGenerator zn){
        for (int i = 0; i < zn.getZombieNumber(); i++) {
            int x = r.nextInt(1280);
            int y= r.nextInt(720);
            int loc=r.nextInt(4);
            switch (loc){
                case 0: zn.z.get(i).setBounds(x, 780, zn.z.get(i).getSizeX(),zn.z.get(i).getSizeY());
                break;
                case 1:zn.z.get(i).setBounds(0, y, zn.z.get(i).getSizeX(),zn.z.get(i).getSizeY());
                break;
                case 2 :zn.z.get(i).setBounds(x, 0, zn.z.get(i).getSizeX(),zn.z.get(i).getSizeY());
                break;
                case 3: zn.z.get(i).setBounds(1200, y, zn.z.get(i).getSizeX(),zn.z.get(i).getSizeY());
                break;
            }
            Background.add(zn.z.get(i));
        }}
      public void setBackground(ImageIcon IC){
      
      Background = Background = new ImagePanel(IC.getImage());
      c.add(Background);
      mapdim=Background.getSize();
      
    
      
      zm_sound = new Random();
      }
      public void zomsound(){
          int sound = zm_sound.nextInt(9);
          switch(sound){
              case 0:
                  Map.playback1();
                  break;
              case 1:
                  Map.playback2();
                  break;
              case 2:
                  Map.playback3();
                  break;
              case 3:
                  Map.playback4();
                  break;
              case 4:
                  Map.playback5();
                  break;
              case 5:
                  Map.playback6();
                  break;
              case 6:
                  Map.playback7();
                  break;
              case 7:
                  Map.playback8();
                  break;
              case 8:
                  Map.playback9();
                  break;
          }
      }
      public static void playback1(){
          try{
                File file1 = new File("sprint0.wav");
                Clip clip1 = AudioSystem.getClip();
                clip1.open(AudioSystem.getAudioInputStream(file1));
                clip1.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback2(){
          try{
                File file2 = new File("sprint1.wav");
                Clip clip2 = AudioSystem.getClip();
                clip2.open(AudioSystem.getAudioInputStream(file2));
                clip2.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback3(){
          try{
                File file3 = new File("sprint2.wav");
                Clip clip3 = AudioSystem.getClip();
                clip3.open(AudioSystem.getAudioInputStream(file3));
                clip3.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback4(){
          try{
                File file4 = new File("sprint3.wav");
                Clip clip4 = AudioSystem.getClip();
                clip4.open(AudioSystem.getAudioInputStream(file4));
                clip4.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback5(){
          try{
                File file5 = new File("sprint4.wav");
                Clip clip5 = AudioSystem.getClip();
                clip5.open(AudioSystem.getAudioInputStream(file5));
                clip5.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback6(){
          try{
                File file6 = new File("sprint5.wav");
                Clip clip6 = AudioSystem.getClip();
                clip6.open(AudioSystem.getAudioInputStream(file6));
                clip6.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback7(){
          try{
                File file7 = new File("sprint6.wav");
                Clip clip7 = AudioSystem.getClip();
                clip7.open(AudioSystem.getAudioInputStream(file7));
                clip7.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback8(){
          try{
                File file8 = new File("sprint7.wav");
                Clip clip8 = AudioSystem.getClip();
                clip8.open(AudioSystem.getAudioInputStream(file8));
                clip8.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public static void playback9(){
          try{
                File file9 = new File("sprint8.wav");
                Clip clip9 = AudioSystem.getClip();
                clip9.open(AudioSystem.getAudioInputStream(file9));
                clip9.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
}