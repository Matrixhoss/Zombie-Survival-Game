
package survivalgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

public class ZombieGenerator {
   
    private int ZombieNumber;
    private int NormalNumber;
    private int FastNumber;
    
    
        public ArrayList<Zombie>z=new ArrayList<Zombie>();
    Random r;
    public ZombieGenerator (){
        
       //NormalZombies
           NormalNumber=5*Waves.getWave();
           ZombieNumber+=NormalNumber;
           for (int i = 0; i < NormalNumber; i++) {
                 
                  z.add(new ZombieNormal());
                 
                  if (z.get(i).isDead())
                      ZombieNumber-=1;
                
               }
     
          //StrongZombies
//           for (int i = 0; i < ZombieNumber; i++) {
//                     if(Waves.getWave()==2)
//                         
//                     z.add(new ZombieStrong());
//                     if (z.get(i).isDead())
//                      ZombieNumber-=1;
//               }
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
//           for (int i = 0; i < ZombieNumber; i++) {
//                     if(Waves.getWave()==2)
//                         
//                     z.add(new ZombieStrong());
//                     if (z.get(i).isDead())
//                      ZombieNumber-=1;
//               }
          //FastZombies
           
            FastNumber=2*Waves.getWave();
            ZombieNumber+=FastNumber;
           for (int i = 0; i < FastNumber; i++) {
                    z.add(new ZombieFast());
                    if (z.get(i).isDead())
                      ZombieNumber-=1;
               
         
 
       }}
    
    
    
}
