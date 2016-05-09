
package survivalgame;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

class bullet extends JLabel{
    public Rectangle b;
bullet (int x, int y){
    b = new Rectangle (x,y,10,10);
    //ImageIcon BulletImage = new ImageIcon(getClass().getResource("misc/TestBullet.png"));
    //this.setIcon(BulletImage);
    this.setSize(20,20);
}    
void MoveBulletBy(int x,int y){
    b.x+=x;
    b.y+=y;
}
Rectangle GetBullet(){
    return b;
}
}
public class Player extends Character {
    // position on axis
   private   int x = 0 ;

   private   int y = 0 ;
 
   // boolean of arros
   private   boolean up , down , right , left ;
   // angle of rotation
   private int angle = 0 ;
   private Weapons[] PWeapon = new Weapons[3];
   private int CurrentWeapon;
   private boolean Fired,Firing;
   private Dimension mapdim;
   private ImagePanel drawpanel;
   private ArrayList<bullet> bullets = new ArrayList();
   private ZombieGenerator zombies;
    Player(int H,int S,JFrame frame, int xL , int yL,ImagePanel drawpanel,Dimension mapdim,ZombieGenerator zombies){
        super(S,H);
        this.drawpanel=drawpanel;
        this.mapdim=mapdim;
        this.x = xL ;
        this.y = yL ;
        Fired=false;
        Firing=false;
        PWeapon[0] = new Pistol();
        CurrentWeapon=0;
        this.zombies=zombies;
        // key listener for arrowkeys
        frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent ke) {
            // when press key of arrows set its boolean true 
            switch (ke.getKeyCode()){
                case KeyEvent.VK_RIGHT :
                    right = true ;
                    break;
                case KeyEvent.VK_LEFT :
                    left = true ;
                    break;    
                case KeyEvent.VK_UP :
                    up = true ;
                    break;     
                case KeyEvent.VK_DOWN :
                    down = true ;
                    break;  
                case KeyEvent.VK_F:
                if(Fired==false){
                bullets.add(new bullet(x,y));
                drawpanel.add(bullets.get(bullets.size()-1));
                bullets.get(bullets.size()-1).setLocation(x,y);
                Firing=PWeapon[CurrentWeapon].Fire();
                Fired=true;
                break;
                }
            }
        }

       @Override
       public void keyReleased(KeyEvent ke) {
            // when releas key of arrows set its boolean false
            switch (ke.getKeyCode()){
                case KeyEvent.VK_RIGHT :
                    right = false ;
                    break;
                case KeyEvent.VK_LEFT :
                    left = false ;
                    break;    
                case KeyEvent.VK_UP :
                    up = false ;
                    break;     
                case KeyEvent.VK_DOWN :
                    down = false ;
                    break;       
                case KeyEvent.VK_F :
                    Fired=false;
                    break;  
            }
       }
});
        
       //
    }
    // get x of player
    public int getx(){
    return this.x;
    }
    // get y of player 
    public int gety(){
    return this.y;
    }
    // get speed of player 
    public int getSpeed (){
    return super.getSpeed();
    }
// move palyer 
    public void move (Dimension d){
        // check of boolean of arrow is true or false if and check bounds 
        // if true set the new value of axis * speed 
     if (up) {
         if (!(y < 0))
         y = (y)-(this.getSpeed());
        
        }
        if (down) {
         if (!(y > mapdim.height-this.getSize().height))
            y = (y)+(this.getSpeed());
        
        }
        if (right) {
           if (!(x > mapdim.width-this.getSize().width))
             x = (x)+(this.getSpeed());
            
        }
        if (left) {
          if (!(x < 0))
            x = (x)-(this.getSpeed());
           
        }
    
        //this.setLocation(x, y);
    }
    
    public void FireHandling (){
        
        
        for(int i=0;i<bullets.size();i++){
            bullet temp = bullets.get(i);
            temp.MoveBulletBy(50, 0);
            bullets.set(i, temp);
            bullets.get(i).setLocation(temp.b.x,temp.b.y);
            for(int j=0;j<zombies.z.size();j++){
                if((Math.abs(temp.getX()-zombies.z.get(j).getX())<=50) && (Math.abs(temp.getY()-zombies.z.get(j).getY())<=50)){
                   Zombie z=zombies.z.get(j);
                   zombies.z.remove(j);
                   drawpanel.remove(z);
                   bullets.remove(i);
                   drawpanel.remove(temp);
                   j=-1;
                   i=-1;
                   break;
                }
            }
            if((temp.b.getX()>mapdim.width)||(temp.b.getY()>mapdim.height)){
                    bullets.remove(i);
                    drawpanel.remove(temp);
                }
        }
    }
    
}
