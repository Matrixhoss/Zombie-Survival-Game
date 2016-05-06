
package survivalgame;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;


public class Player extends Character {
   private   int x = 0 ;
   private   int y = 0 ;
   private   boolean up , down , right , left ;
    Player(int H,int S,Weapons W,JFrame frame, int x , int y){
        super(S,H,W);
        this.x = x ;
        this.y = y ;
        
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
          if (!(y > d.height-50))
            y = (y)+(this.getSpeed());
        }
        if (right) {
           if (!(x > d.width-50))
              x = (x)+(this.getSpeed());
        }
        if (left) {
          if (!(x < 0))
             x = (x)-(this.getSpeed());
        }
    
        //this.setLocation(x, y);
    }
}
