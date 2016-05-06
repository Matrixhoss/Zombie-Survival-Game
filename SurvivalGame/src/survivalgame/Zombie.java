
package survivalgame;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Zombie extends Character  {
    private String Type;
    Random r;
//    private MELEE m;
//    private MELEE2 m2;
//    private MELEEFast m3;
    
    public Zombie (int health,int speed,String Type){
        super(health,speed);
        this.Type=Type;
        
            switch (Type){
            case "Normal":
                this.setWeapon(new MELEE());
                break;
            case "Strong":
                this.setWeapon(new MELEE2());
                break;
            case "Fast":
                this.setWeapon(new MELEEFast());
                break;
            }
    }
    public Zombie (int health,int speed){
    super(health,speed);
          int rand=r.nextInt(3);
        switch (rand){
            case 1:
                this.Type="Normal";
                this.setWeapon(new MELEE());
                break;
            case 2:
                this.Type="Strong";
                this.setWeapon(new MELEE2());
                break;
                
            case 3:
                this.Type="Fast";
                this.setWeapon(new MELEEFast());
                break;
                
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
    public void takeDamage(int d ){
    
    
    }
    public void setWeapon(){
    
    }
    
    
}
