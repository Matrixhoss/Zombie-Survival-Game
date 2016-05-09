
package survivalgame;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class bullet extends JLabel{
    public Rectangle b;
bullet (int x, int y){
    b = new Rectangle (x,y,10,10);
    ImageIcon BulletImage = new ImageIcon(getClass().getResource("misc/TestBullet.png"));
    this.setIcon(BulletImage);
    this.setSize(100,100);
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
   private   int x = 0 ;
   private   int y = 0 ;
   private   boolean up , down , right , left ;
   private Weapons[] PWeapon = new Weapons[3];
   private int CurrentWeapon;
   private boolean Firing;
   private Dimension mapdim;
   private ImagePanel drawpanel;
   private ArrayList<bullet> bullets = new ArrayList();
    Player(int H,int S,JFrame frame, int xL , int yL,ImagePanel drawpanel,Dimension mapdim){
        super(S,H);
        this.drawpanel=drawpanel;
        this.mapdim=mapdim;
        this.x = xL ;
        this.y = yL ;
        PWeapon[0] = new Pistol();
        CurrentWeapon=0;
        frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent ke) {
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
                bullets.add(new bullet(x,y));
                drawpanel.add(bullets.get(bullets.size()-1));
                bullets.get(bullets.size()-1).setLocation(x,y);
                Firing=PWeapon[CurrentWeapon].Fire();
                break;
                
            }
        }

       @Override
       public void keyReleased(KeyEvent ke) {
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
            }
       }
});
        
       //
    }
    public int getx(){
    return this.x;
    }
    public int gety(){
    return this.y;
    }
    public int getSpeed (){
    return super.getSpeed();
    }

    public void move (Dimension d){
     if (up) {
         if (!(y < 0))
             
          y = (y)-(this.getSpeed());
        }
        if (down) {
          if (!(y > 650))
            y = (y)+(this.getSpeed());
        }
        if (right) {
           if (!(x > 1300))
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
            if((temp.b.getX()>=mapdim.width)||(temp.b.getY()>=mapdim.height)){
                    bullets.remove(i);
                    continue;
                }
            bullets.set(i, temp);
            bullets.get(i).setLocation(temp.b.x,temp.b.y);
        }
    }
}
