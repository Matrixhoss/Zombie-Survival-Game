
package survivalgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

public class ZombieGenerator {
   
    private int ZombieNumber=5;
     
        public ArrayList<Zombie>z=new ArrayList<Zombie>();
    Random r;
    public ZombieGenerator ( String Type){
        
       switch (Type){
       case "ZombieNormal":
          
           for (int i = 0; i < ZombieNumber; i++) {
                  z.add(new ZombieNormal());
                  if (z.get(i).isDead())
                      ZombieNumber-=1;
               }
           break;
       case "ZombieStrong":
           for (int i = 0; i < ZombieNumber; i++) {
                     z.add(new ZombieStrong());
                     if (z.get(i).isDead())
                      ZombieNumber-=1;
               }
           break;
       case "ZombieFast":
           for (int i = 0; i < ZombieNumber; i++) {
                    z.add(new ZombieFast());
                    if (z.get(i).isDead())
                      ZombieNumber-=1;
               }
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
