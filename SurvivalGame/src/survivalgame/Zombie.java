
package survivalgame;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Zombie extends Character {
    private String Type;
    
    
    public Zombie (int health,int speed,Weapons Weapon,String Type){
        super(health,speed,Weapon);
        this.Type=Type;
        
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
