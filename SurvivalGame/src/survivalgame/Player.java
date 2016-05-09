
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
    public int direction;
    
bullet (int x, int y){
    b = new Rectangle (x,y,10,10);
    ImageIcon BulletImage = new ImageIcon(getClass().getResource("misc/TestBullet.png"));
    this.setIcon(BulletImage);
    this.setSize(20,20);
}    
bullet (int x, int y,int direction){
    b = new Rectangle (x,y,10,10);
    ImageIcon BulletImage = new ImageIcon(getClass().getResource("misc/TestBullet.png"));
    this.setIcon(BulletImage);
    this.setSize(20,20);
    this.direction=direction;
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
   private int stopPosition  = 5  ;
   private   int y = 0 ;
 
   // boolean of arros
   private   boolean up , down , right , left ;
   // angle of rotation
   private int angle = 0 ;
   private int direction=1;
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
                if(right)
                    direction=1;
                if(left)
                    direction=2;
                if(up)
                    direction=3;
                if(down)
                    direction=4;
                bullets.add(new bullet(x,y,direction));
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
            switch(temp.direction){
                case 1://right
                    temp.MoveBulletBy(50, 0);
                    break;
                case 2://left
                    temp.MoveBulletBy(-50, 0);
                    break;
                case 3://up
                    temp.MoveBulletBy(0, -50);
                    break;
                case 4://down
                    temp.MoveBulletBy(0, 50);
                    break;
            }
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
    public void animation (){
        int stopPosition  = 5  ;
        if  (up && right){
        this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierUpRight.gif")));
        stopPosition  = 1 ;
        }
        else if  (up && left){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierUpLeft.gif")));
         stopPosition  = 2 ;
        } 
        else if  (down && right){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierDownRight.gif")));
         stopPosition  = 3;
        }
        else if  (down && left){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierDownLeft.gif")));
         stopPosition  = 4;
        }
        else if  (up){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierGif.gif")));
         stopPosition  = 5;
        }
        else if  (down){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierDown.gif")));
         stopPosition  = 6;
        }
        else if  (right){
        this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierRight.gif")));
        stopPosition  = 7;
        }
        else if  (left){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierLeft.gif")));
         stopPosition  = 8 ;
        }
        else{
            if(stopPosition  == 1){
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/UpRight.png")));
           if(stopPosition  == 2)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/UpLeft.png")));
           if(stopPosition  == 3)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/DownRight.png")));
           if(stopPosition  == 4)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/DownLeft.png")));
           if(stopPosition  == 5)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png")));
           if(stopPosition  == 6)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Down.png")));
           if(stopPosition  == 7)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Right.png")));
           if(stopPosition  == 8)
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Left.png")));
           
        }
    
}
    }}