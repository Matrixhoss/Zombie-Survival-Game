
package survivalgame;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Zombie extends Character  {
    
    private String Type;
    Random r;
    
    public Zombie (int health,int speed,String Type){
        super(health,speed);
        this.Type=Type;

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

    
    public void move(){
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
        super(20,50,"Normal");
        this.setWeapon(new MELEE());
        }
    }
    class ZombieStrong extends Zombie{
    
        public ZombieStrong(){
        super(40,40,"Strong");
        this.setWeapon(new MELEE2());
        }
    }
    class ZombieFast extends Zombie{

        public ZombieFast(){
         super(10,150,"Fast");
        this.setWeapon(new MELEEFast());
        }
    }
