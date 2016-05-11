package survivalgame;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class ZombieGenerator {
    public static int score;
    private Random zm_die;
    private int ZombieNumber;
    private int NormalNumber;
    private int FastNumber;
    private int StrongNumber;
    private ImagePanel drawpanel;
    
    public ArrayList<Zombie>z=new ArrayList<Zombie>();
    Random r;
    public ZombieGenerator (ImagePanel drawpanel){
        zm_die = new Random();
        this.drawpanel=drawpanel;
       //NormalZombies
       NormalNumber=5*Waves.getWave();
       ZombieNumber+=NormalNumber;
       for (int i = 0; i < NormalNumber; i++) {
           z.add(new ZombieNormal());
           if (z.get(i).isDead())
               ZombieNumber-=1; 
       }
          //StrongZombies
          if(Waves.getWave()>=5){
              StrongNumber=Waves.getPrevWave();
              ZombieNumber+=FastNumber;
              for (int i = 0; i < StrongNumber; i++) {
                  z.add(new ZombieStrong());
                  if (z.get(i).isDead())
                      ZombieNumber-=1;
               }}
          //FastZombies
          if(Waves.getWave()>=3){
              FastNumber=2*Waves.getWave();
              ZombieNumber+=FastNumber;
              for (int i = 0; i < FastNumber; i++) {
                  z.add(new ZombieFast());
                  if (z.get(i).isDead())
                      ZombieNumber-=1;
              }
          }
    }
    public void TakeDamage(int index, int damage){
        z.get(index).setHealth(z.get(index).getHealth()-damage);
        if(z.get(index).getHealth()<=0){
            drawpanel.remove(z.get(index));
            z.remove(index);
            zomdeath();
            ZombieNumber--;
            score=score+10;
        }
    }
    public int getZombieNumber(){
        return this.ZombieNumber;
    }
    public void setZombieNumber(int n){
        this.ZombieNumber=n;
    }
    public void updateZombie(){
        ZombieNumber=0;
        NormalNumber=5*Waves.getWave();
        ZombieNumber+=NormalNumber;
        for (int i = 0; i < NormalNumber; i++) {
            z.add(new ZombieNormal());
            if (z.get(i).isDead())
                ZombieNumber-=1;
        }
        //StrongZombies
        if(Waves.getWave()>=5){
              StrongNumber=2*(Waves.getPrevWave()-2);
            ZombieNumber+=StrongNumber;
            for (int i = 0; i < StrongNumber; i++) {
                z.add(new ZombieStrong());
                if (z.get(i).isDead())
                    ZombieNumber-=1;
            }
        }
          //FastZombies
         if(Waves.getWave()>=3){
            FastNumber=2*Waves.getWave();
            ZombieNumber+=FastNumber;
            for (int i = 0; i < FastNumber; i++) {
                z.add(new ZombieFast());
                if (z.get(i).isDead())
                    ZombieNumber-=1;
            }}
    }
    public void zomdeath(){
          int sound = zm_die.nextInt(11);
          switch(sound){
              case 0:
                  ZombieGenerator.playback1();
                  break;
              case 1:
                  ZombieGenerator.playback2();
                  break;
              case 2:
                  ZombieGenerator.playback3();
                  break;
              case 3:
                  ZombieGenerator.playback4();
                  break;
              case 4:
                  ZombieGenerator.playback5();
                  break;
              case 5:
                  ZombieGenerator.playback6();
                  break;
              case 6:
                  ZombieGenerator.playback7();
                  break;
              case 7:
                  ZombieGenerator.playback8();
                  break;
              case 8:
                  ZombieGenerator.playback9();
                  break;
              case 9:
                  ZombieGenerator.playback10();
                  break;
              case 10:
                  ZombieGenerator.playback11();
                  break;
          }
      }
    public static void playback1(){
          try{
                File file1 = new File("death3.wav");
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
                File file2 = new File("death0.wav");
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
                File file3 = new File("death1.wav");
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
                File file4 = new File("death2.wav");
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
                File file5 = new File("death4.wav");
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
                File file6 = new File("death5.wav");
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
                File file7 = new File("death6.wav");
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
                File file8 = new File("death7.wav");
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
                File file9 = new File("death8.wav");
                Clip clip9 = AudioSystem.getClip();
                clip9.open(AudioSystem.getAudioInputStream(file9));
                clip9.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
    public static void playback10(){
          try{
                File file10 = new File("death9.wav");
                Clip clip10 = AudioSystem.getClip();
                clip10.open(AudioSystem.getAudioInputStream(file10));
                clip10.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
    public static void playback11(){
          try{
                File file11 = new File("death10.wav");
                Clip clip11 = AudioSystem.getClip();
                clip11.open(AudioSystem.getAudioInputStream(file11));
                clip11.start();
          }
          catch(Exception e){
              System.err.println(e.getMessage());
          }
      }
}