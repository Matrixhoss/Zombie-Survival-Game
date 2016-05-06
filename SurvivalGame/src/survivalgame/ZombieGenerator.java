
package survivalgame;

import java.util.Random;
import javax.swing.ImageIcon;

public class ZombieGenerator {
   
    private int ZombieNumber=5;
    Zombie[] z = new Zombie[ZombieNumber];
    Random r;
    public ZombieGenerator ( String Type){
       switch (Type){
       case "ZombieNormal":
           System.out.println("asdasdasdasd");
           for (int i = 0; i < ZombieNumber; i++) {
                   z[i]=new ZombieNormal();
                   z[i].setIcon( new ImageIcon(getClass().getResource("misc/Sprites/ZombieWalk_normal_scaled_fast.gif")));
               }
           break;
       case "ZombieStrong":
           for (int i = 0; i < ZombieNumber; i++) {
                   z[i]=new ZombieStrong();
               }
           break;
       case "ZombieFast":
           for (int i = 0; i < ZombieNumber; i++) {
                   z[i]=new ZombieFast();
               }
           
           break;
       default:
          System.out.println("asdasdasdasd");
           break;
           
           
       
       
       }
        
   
    
    }
    public int getZombieNumber(){
    return this.ZombieNumber;
    }
    public void setZombieNumber(int n){
  this.ZombieNumber=n;
    }
    
    
    
}
