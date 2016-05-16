package survivalgame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static survivalgame.main_menu.x;

public class All_map extends JFrame {
    private JLabel score1;
    private Random zm_sound;
    private ZombieNormal z ;
    private ImagePanel Background;
    private ZombieGenerator zn;
    private ZombieGenerator zf;
    private Player p2;
    private Player p ;
    private Random r;
    private Random R;
    private JLabel WaveTxt;
    private JLabel WavePopUp;
    private JLabel Name;
    private JLabel Name2;
    private JLabel HealthBar;
    private JLabel HealthBar2;
    private boolean StartedNewMap;
    private JLabel NumberofRZ;
    public static int NumberOfPlayers;
    private Dimension mapdim = new Dimension();
    ImageIcon MapIcn= new ImageIcon(getClass().getResource("misc/Map1.jpg"));
    ImageIcon Zombierawr= new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
    ImageIcon Playericon  = new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png"));
    Timer t;
    Timer t2;

    private Container c;
     
    private int TotalNumberOfZombies;
    
    static int sc=0;
    public All_map(ImageIcon icon){
    c = this.getContentPane();
    setBackground(icon);
      r= new Random();
      
      zn=new ZombieGenerator(Background);
      
      WaveTxt=new JLabel("Wave: "+Waves.getWave());
      WaveTxt.setBounds(610, 0, 100, 60);
      Background.add(WaveTxt);
      WaveTxt.setFont(new Font("Stencil Regular", Font.BOLD, 20));
      
      NumberofRZ=new JLabel("Remaining Zombies: "+zn.getZombieNumber());
      NumberofRZ.setBounds(550, 20, 400, 60);
      Background.add(NumberofRZ);
      NumberofRZ.setFont(new Font("Stencil Regular", Font.BOLD, 20));
      
      WavePopUp=new JLabel("Wave Clear ");
      WavePopUp.setBounds(400,100, 1000,400);
      WavePopUp.setFont(new Font("Stencil Regular", Font.BOLD, 100));
      WavePopUp.setForeground(Color.RED);
      WavePopUp.setVisible(false);
      Background.add(WavePopUp);
      
      Name=new JLabel(no_of_players.getPlayer(1));
      Name.setBounds(0, 0, 100, 60);
      Background.add(Name);
      Name.setFont(new Font("Stencil Regular", Font.BOLD, 20));
      
      Name2=new JLabel(no_of_players.getPlayer(2));
      Name2.setBounds(100, 0, 100, 60);
      Background.add(Name2);
      Name2.setFont(new Font("Stencil Regular", Font.BOLD, 20));
      Name2.setVisible(false);
      if(NumberOfPlayers==2){
      Name2.setVisible(true);
      }
      
      HealthBar=new JLabel(new ImageIcon(getClass().getResource("misc/Sprites/Health1.png")));
      HealthBar.setBounds(Name.getX()+80,-2,100,70);
      Background.add(HealthBar);
      
      if(NumberOfPlayers==2){
       HealthBar2=new JLabel(new ImageIcon(getClass().getResource("misc/Sprites/Health1.png")));
      HealthBar2.setBounds(Name.getX()+80,30,100,70);
      Background.add(HealthBar2);}
      
      score1=new JLabel("Score: "+ZombieGenerator.score);
      score1.setBounds(0, 10, 400, 120);
      Background.add(score1);
      score1.setFont(new Font("Stencil Regular", Font.BOLD, 20));
      
      GenerateZombie(zn);
      if(NumberOfPlayers==2){
      p2 = new Player (100,10,this,200,400,Background,mapdim,zn,2);
      p2.setIcon(Playericon);
      p2.setSize(100, 100);
      this.StartedNewMap=false;
      Background.add(p2);
      play();}
      
      p = new Player (100,10,this,200,400,Background,mapdim,zn,1);
      p.setIcon(Playericon);
      p.setSize(100, 100);
      this.StartedNewMap=false;
      Background.add(p);
      play();
      
      
      
    t2=new Timer(8000,new ActionListener(){
    public void actionPerformed(ActionEvent e){
        WavePopUp.setVisible(false);
        if (zn.z.isEmpty()){
           //Play starting round
           play();
           Waves.setNextWave();
           WaveTxt.setText("Wave: "+Waves.getWave());
           NumberofRZ.setText("Remaining Zombies: "+zn.getZombieNumber());
           zn.updateZombie();
           GenerateZombie(zn);
        }
        }});
    
    t=new Timer(30,new ActionListener(){
        boolean n=r.nextBoolean();
        int t = 0;
        public void actionPerformed(ActionEvent e) {
         
           for (int i = 0; i < zn.z.size(); i++){ 
               if(NumberOfPlayers==2){
            if(p2.getHealth()<=0||p.getHealth()<=0){  
            Player live=p.getHealth()>p2.getHealth()?p:p2;
            zn.z.get(i).AI(live.getX(),live.getY());
            zn.z.get(i).rotation();
            }
               if(p2.getHealth()>0&&p.getHealth()>0){     
                if(i%2==0){    
                zn.z.get(i).AI(p.getX(),p.getY());
            
                zn.z.get(i).rotation();
            }
            else{
            zn.z.get(i).AI(p2.getX(),p2.getY());
            zn.z.get(i).rotation();
            }
          }}
               else{
               zn.z.get(i).AI(p.getX(),p.getY());
                 zn.z.get(i).rotation();
               
               }
          
            if(t!=0)
            t--;
        else {
            t=30;
            if((Math.abs(zn.z.get(i).getX()-p.getX())<=60)&&(Math.abs(zn.z.get(i).getY()-p.getY())<=60)){
                
                System.out.println(p.getHealth());
                
                if(NumberOfPlayers==2){
                  
                
                if(p.getHealth()>0){
                    p.takeDamage(zn.z.get(i).weapon.damage);
                    System.out.println(p.getHealth());
                     hit();
                }
                if(p.getHealth()<=0){
//                    MissionFailed();
//                    game_over();
                    p.setEnabled(false);
                    p.setVisible(false);
                    p.die();}
           
                }
                else if (NumberOfPlayers==1){
                   if(p.getHealth()>0){
                    p.takeDamage(zn.z.get(i).weapon.damage);
                    System.out.println(p.getHealth());
                     hit();}
                if(p.getHealth()<=0){
                    MissionFailed();
                    game_over();
                    p.setEnabled(false);
                    p.setVisible(false);
                    p.die();}
           
                }
           
                
                
            }
            if(NumberOfPlayers==2){             //CASE Number of players = 2 we enable the 2nd player to move,die and take damage
               if((Math.abs(zn.z.get(i).getX()-p2.getX())<=60)&&(Math.abs(zn.z.get(i).getY()-p2.getY())<=60)){
               
                if(p2.getHealth()>0){
                p2.takeDamage(zn.z.get(i).weapon.damage);
                System.out.println(p2.getHealth());
                hit();}
                if(p2.getHealth()<=0){
//                    MissionFailed();
//                    game_over();
                   c.remove(p2);
                   Background.remove(p2);
                    p2.setEnabled(false);
                    p2.setVisible(false);
                    p2.die();
                    
                }}}
                             
            }
            if(NumberOfPlayers==2)
            if(p.getHealth()<=0&&p2.getHealth()<=0){
                    MissionFailed();
                    game_over();
                    p.setEnabled(false);
                    p.setVisible(false);
                    p.die();
                   }
            }
            setHealthBar();
            if (NumberOfPlayers==2){
                setHealthBar2();}
            NumberofRZ.setText("Remaining Zombies: "+zn.getZombieNumber());
        
        if (zn.z.isEmpty()){
            WavePopUp.setVisible(true);
           }
           //z.move();
         if(p.getHealth()>0){
           p.move(mapdim);
           p.animation();
           p.DamageHandling();
           p.setLocation(p.getx(), p.gety());}
           if(NumberOfPlayers==2){
               if(p2.getHealth()>0){
            p2.move(mapdim);
           p2.animation();
           p2.DamageHandling();
           p2.setLocation(p2.getx(), p2.gety());}}
           //System.out.println(Waves.getWave());
           repaint();
           score1.setText("Score: "+ZombieGenerator.score);
           //savescore();
        }
    });
    t.start();
    t2.start();
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(1280, 720);
//    zomsound();
//    Timer ts=new Timer(8000,new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            zomsound();
//        }
//    });
//    ts.start();
    }
    public void game_over(){
        JOptionPane.showMessageDialog(null,new ImageIcon(getClass().getResource("misc/gameover.gif")));
      }
    public void MissionFailed(){
        ZombieGenerator.score=0;
        Waves.setWave(1);
        this.dispose();
        this.removeAll();
        t.stop();
        t2.stop();
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
      public static void play(){
            try{
            File files = new File("round_start.wav");
            Clip clips = AudioSystem.getClip();
            clips.open(AudioSystem.getAudioInputStream(files));
            clips.start();
            }
            catch(Exception es){
                System.err.println("");
            }
      }
      public static void hit(){
          try{
                File fileh = new File("attack.wav");
                Clip cliph = AudioSystem.getClip();
                cliph.open(AudioSystem.getAudioInputStream(fileh));
                cliph.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
      public void setHealthBar(){
          if (p.getHealth()==100){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health1.png")));
          }
          if (p.getHealth()==90){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health2.png")));
          }
          if (p.getHealth()==80){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health3.png")));
          }
          if (p.getHealth()==70){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health4.png")));
          }
          if (p.getHealth()==60){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health5.png")));
          }
          if (p.getHealth()==50){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health6.png")));
          }
          if (p.getHealth()==40){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health7.png")));
          }
          if (p.getHealth()==30){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health8.png")));
          }
          if (p.getHealth()==20){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health9.png")));
          }
          if (p.getHealth()==10){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health11.png")));
          }
          if (p.getHealth()==0){
              HealthBar.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health10.png")));
          }
      }
      public void setHealthBar2(){
          if (p2.getHealth()==100){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health1.png")));
          }
          if (p2.getHealth()==90){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health2.png")));
          }
          if (p2.getHealth()==80){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health3.png")));
          }
          if (p2.getHealth()==70){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health4.png")));
          }
          if (p2.getHealth()==60){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health5.png")));
          }
          if (p2.getHealth()==50){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health6.png")));
          }
          if (p2.getHealth()==40){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health7.png")));
          }
          if (p2.getHealth()==30){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health8.png")));
          }
          if (p2.getHealth()==20){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health9.png")));
          }
          if (p2.getHealth()==10){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health11.png")));
          }
          if (p2.getHealth()==0){
              HealthBar2.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Health10.png")));
              c.remove(p2);
          }
      }
      public static void savescore(){
        File newfile = new File("Highscore.txt");
        if(newfile.exists()){
            System.out.println("Rename the file");
        }
        else{
            try{
                newfile.createNewFile();
            }
            catch(Exception e){
                System.err.println("Error");
            }
            try{
                FileWriter score_file = new FileWriter(newfile);
                BufferedWriter score_buff = new BufferedWriter(score_file);
                //Th new score of the user
                score_buff.write(ZombieGenerator.score);
                score_buff.close();
                score_file.close();
            }
            catch(Exception e){
                System.err.println("Error");
            }
        }
    }
      /*public void zomsound(){
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
      }*/
}
