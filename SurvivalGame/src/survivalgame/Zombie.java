
package survivalgame;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static survivalgame.Constants.*;


public abstract class Zombie extends Character  {
    
    private String Type;
    Random r;
    ImageIcon shape;
    
    public Zombie (int health,int speed,String Type){
        super(health,speed);
        this.Type=Type;

    }
    public Zombie (String T){
        super(20,50);
        switch (T){
            case "ZombieNormal":
                this.sethealth(20);
                this.setSpeed(40);
                break;
            case"ZombieStrong":
                this.sethealth(40);
                this.setSpeed(30);
                break;
            case"ZombieFast":
                this.sethealth(10);
                this.setSpeed(110);
                  break;
                        
        }
        
      
    }
    public Zombie (int health,int speed){
    super(health,speed);
          int rand=r.nextInt(3);
        switch (rand){
            case 1: 
                
            case 2:  
            case 3:
        
        }
    }

    
    public void move(int xOfplayer,int yOfplayer){
        
        
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
}
  class ZombieNormal extends Zombie{
        
        public ZombieNormal(){  
        super("ZombieNormal");
         shape=new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif"));
        this.setWeapon(new MELEE());
        this.setIcon(shape);
        }
    }
    class ZombieStrong extends Zombie{
    
        public ZombieStrong(){
        super("ZombieStrong");
        this.setWeapon(new MELEE2()); //Missing image
        }
    }
    class ZombieFast extends Zombie{

        public ZombieFast(){
         super("ZombieFast");
         shape = new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_odd_fast.gif"));
        this.setWeapon(new MELEEFast());
        this.setIcon(shape);
        }
    }
