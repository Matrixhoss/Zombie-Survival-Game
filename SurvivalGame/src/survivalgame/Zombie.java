
package survivalgame;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Zombie extends Character  {
    private String Type;
    Random r;
    private MELEE m;
    
    public Zombie (int health,int speed,Weapons Weapon,String Type){
        super(health,speed,Weapon);
        this.Type=Type;
        
    }
    public Zombie (int health,int speed,Weapons Weapon){
    super(health,speed,Weapon);
          int rand=r.nextInt(3);
        switch (rand){
            case 1:
                this.Type="Class C";
                this.setWeapon(m);
                break;
            case 2:
                this.Type="Class B";
                break;
                
            case 3:
                this.Type="Class A";
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
          Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }
    public void takeDamage(int d ){
    
    
    }
    public void setWeapon(){
    
    }
    
    
}
