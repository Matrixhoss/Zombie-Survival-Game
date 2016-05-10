
package survivalgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

public class ZombieGenerator {
   
    private int ZombieNumber;
    private int NormalNumber;
    private int FastNumber;
    private int StrongNumber;
    private ImagePanel drawpanel;
    
    
        public ArrayList<Zombie>z=new ArrayList<Zombie>();
    Random r;
    public ZombieGenerator (ImagePanel drawpanel){
        
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
           if(Waves.getWave()==2){
               StrongNumber=1;
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
           if(Waves.getWave()==2){
               StrongNumber=1;
               ZombieNumber+=StrongNumber;
           for (int i = 0; i < StrongNumber; i++) {  
                     z.add(new ZombieStrong());
                     if (z.get(i).isDead())
                      ZombieNumber-=1;
               }}
          //FastZombies
           
            FastNumber=2*Waves.getWave();
            ZombieNumber+=FastNumber;
           for (int i = 0; i < FastNumber; i++) {
                    z.add(new ZombieFast());
                    if (z.get(i).isDead())
                      ZombieNumber-=1;
               
         
 
       }}
    
    
    
}
