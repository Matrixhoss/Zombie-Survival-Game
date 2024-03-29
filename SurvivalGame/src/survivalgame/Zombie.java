
package survivalgame;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static survivalgame.Constants.*;


public abstract class Zombie extends Character  {
   
    public int x;
    public int y;
    public int FollowedPlayer;
    public String Type;
    private Random r;
    ImageIcon shape;
    private double angle;
    private int sizeX;
    private int sizeY;
    public Weapons weapon;
    public double scale;
    public int CollX;
    public int CollY;
    public int space=0;
    public Zombie (int health,int speed,String Type){
        super(health,speed);
        this.Type=Type;

    }
    public Zombie (String T){
        super(20,50);
        r=new Random();
       Random x=new Random();
       
       this.FollowedPlayer=x.nextInt(2);
       System.out.println(FollowedPlayer);
       int RandS=r.nextInt(5);//RandS to make zombies have different value
        switch (T){
            case "ZombieNormal":
                this.setHealth(20);
                this.setSpeed(40+RandS);
                break;
            case"ZombieStrong":
                this.setHealth(200);
                this.setSpeed(30+RandS);
                break;
            case"ZombieFast":
                this.setHealth(10);
                this.setSpeed(80+RandS);
                  break;
                        
        }
      
    }
    
    public boolean isDead(){
        return this.getHealth()==0;
        }
    public void setSizeX(int x){
        this.sizeX=x;
    }
     public void setWeapon(Weapons w){
    this.weapon=w;
    }
    public Weapons getWeapon(){
    return this.weapon;
    }
    public void setSizeY(int y){
        this.sizeY=y;
    }
    public int getSizeX(){
        return this.sizeX;
    }
    public int getSizeY(){
        return this.sizeY;
    }
    public double GetAngle(){
        return angle;
    }
//    public Zombie (int health,int speed){
//    super(health,speed);
//          int rand=r.nextInt(3);
//        switch (rand){
//            case 1: 
//                
//            case 2:  
//            case 3:
//        
//        }
//    }
    public void AI(int xOfplayer,int yOfplayer){
        int DiffX=xOfplayer-this.getX();
        int DiffY=yOfplayer-this.getY();
        angle=Math.atan2(DiffY, DiffX);
        double SX=(this.getSpeed()*S*Math.cos(angle));
        double SY=(this.getSpeed()*S*Math.sin(angle));
        if((DiffX>-50&&DiffX<50)&&(DiffY>-50&&DiffY<50)){
        
        }
        else {
            this.setLocation(this.getX()+(int)SX,this.getY()+(int)SY);
            
        }
    }
    @Override
    public void die(){
      if (this.getHealth()==0)
         try {
             this.finalize();
            
             
      } catch (Throwable ex) {
        System.out.print(ex);
      }
    }
    public void takeDamage(int d ){};
    public void setWeapon(){};
    abstract void rotation();
}
  class ZombieNormal extends Zombie{
       
        public ZombieNormal(){  
        super("ZombieNormal");
        this.Type="ZombieN";
        this.setSizeX(100);
        this.setSizeY(100);
        this.scale=1.4;
        shape=new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
        this.setWeapon(new MELEE());
        this.setIcon(shape);
        this.CollX=64;
        this.CollY=80;
        }
        public void rotation(){
            Double ang=Math.toDegrees(this.GetAngle());
            this.space=1;
            if(ang>-165&&ang>165){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateLeft.gif"));
                this.setIcon(shape);
                
            }
            else if(ang>-165&&ang<-105){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateUpLeft.gif"));
                this.setIcon(shape);
                this.space=10;
                
                
            }
            else if(ang>-105&&ang<-75){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
                this.setIcon(shape);
            }
            else if(ang>-75&&ang<-15){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateUpRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>-15&&ang<15){
                    shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>15&&ang<75){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateDownRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>75&&ang<105){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateDown.gif"));
                this.setIcon(shape);
            }
            else if(ang>105&&ang<165){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/RotateDownLeft.gif"));
                this.setIcon(shape);
            }
        } 
  }
    class ZombieStrong extends Zombie{
    
        public ZombieStrong(){
        super("ZombieStrong");
        this.Type="ZombieS";
        this.setSizeX(200);
        this.setSizeY(200);
        this.setWeapon(new MELEE2()); 
        shape=new ImageIcon(getClass().getResource("misc/Sprites/Boss.gif"));
        this.setIcon(shape);
        this.scale=3.3;
        this.CollX=125;
        this.CollY=165;
        }

   public void rotation(){
            Double ang=Math.toDegrees(this.GetAngle());
            if(ang>-165&&ang>165){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/BossLeft.gif"));
                this.setIcon(shape);
                
            }
            else if(ang>-165&&ang<-105){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/BossUpLeft.gif"));
                this.setIcon(shape);
                this.space=35;
            }
            else if(ang>-105&&ang<-75){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/Boss.gif"));
                this.setIcon(shape);
            }
            else if(ang>-75&&ang<-15){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/BossUpRight.gif"));
                this.setIcon(shape);
                this.space=35;
            }
            else if(ang>-15&&ang<15){
                    shape=new ImageIcon(getClass().getResource("misc/Sprites/BossRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>15&&ang<75){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/BossDownRight.gif"));
                this.setIcon(shape);
                this.space=35;
            }
            else if(ang>75&&ang<105){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/BossDown.gif"));
                this.setIcon(shape);
            }
            else if(ang>105&&ang<165){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/BossDownLeft.gif"));
                this.setIcon(shape);
                this.space=35;
            }
        } 
        
    }
    class ZombieFast extends Zombie{

        public ZombieFast(){
         super("ZombieFast");
         this.Type="ZombieF";
         this.setSizeX(80);
        this.setSizeY(80);
         shape = new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_odd_fast.gif"));
        this.setWeapon(new MELEEFast());
        this.setIcon(shape);
        this.scale=1;
        this.CollX=64;
        this.CollY=64;
        }

    @Override
    void rotation() {
        Double ang=Math.toDegrees(this.GetAngle());
            if(ang>-165&&ang>165){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/FastLeft.gif"));
                this.setIcon(shape);
            }
            else if(ang>-165&&ang<-105){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/FastUpLeft.gif"));
                this.setIcon(shape);
            }
            else if(ang>-105&&ang<-75){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_odd_fast.gif"));
                this.setIcon(shape);
            }
            else if(ang>-75&&ang<-15){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/FastUpRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>-15&&ang<15){
                    shape=new ImageIcon(getClass().getResource("misc/Sprites/FastRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>15&&ang<75){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/FastDownRight.gif"));
                this.setIcon(shape);
            }
            else if(ang>75&&ang<105){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/FastDown.gif"));
                this.setIcon(shape);
            }
            else if(ang>105&&ang<165){
                shape=new ImageIcon(getClass().getResource("misc/Sprites/FastDownLeft.gif"));
                this.setIcon(shape);
            }
    }
        
    }
