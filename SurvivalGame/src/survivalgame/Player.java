package survivalgame;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.Timer;
import static survivalgame.main_menu.x;

class bullet extends JLabel{
    public Rectangle b;
    public int direction;
    public int ShotgunBullet=0; //1 is shotgun bullets going left of main and 2 is one going right of main
    
    
    bullet (int x, int y){
        b = new Rectangle (x,y,10,10);
        ImageIcon BulletImage = new ImageIcon(getClass().getResource("misc/TestBullet.png"));
        this.setIcon(BulletImage);
        this.setSize(10,10);
    }
    bullet (int x, int y,int direction,int ShotgunBullet){
        b = new Rectangle (x,y,10,10);
        ImageIcon BulletImage = new ImageIcon(getClass().getResource("misc/TestBullet.png"));
        this.setIcon(BulletImage);
        this.setSize(20,20);
        this.direction=direction;
        this.ShotgunBullet=ShotgunBullet;
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
   private int direction=1;
   private Weapons[] PWeapon = new Weapons[3];
   public int CurrentWeapon;
   private boolean Fired,Firing;
   private Dimension mapdim;
   private ImagePanel drawpanel;
   private ArrayList<bullet> bullets = new ArrayList();
   private ZombieGenerator zombies;
   public boolean isAlive=true;
   private int damage;
    Player(int H,int S,JFrame frame, int xL , int yL,ImagePanel drawpanel,Dimension mapdim,ZombieGenerator zombies,int PlayerNumber){
        super(S,H);
        
        this.drawpanel=drawpanel;
        this.mapdim=mapdim;
        this.x = xL ;
        this.y = yL ;
        Fired=false;
        Firing=false;
        PWeapon[0] = new Pistol();
        PWeapon[1] = new Shotgun();
        CurrentWeapon=0;
        damage=PWeapon[CurrentWeapon].damage;
        this.zombies=zombies;
        // key listener for arrowkeys
        if (PlayerNumber==1){
        frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent ke) {
            // when press key of arrows set its boolean true 
            
                if(isAlive)
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
                case KeyEvent.VK_9:
                    CurrentWeapon=0;
                    damage=PWeapon[CurrentWeapon].damage;
                    break;
                case KeyEvent.VK_0:
                    CurrentWeapon=1;
                    damage=PWeapon[CurrentWeapon].damage;
                    break;
                    
                case KeyEvent.VK_K:
                if(Fired==false){
                if(CurrentWeapon==1){
                    if(PWeapon[CurrentWeapon].ammo>0){
                        bullets.add(new bullet(x+25 ,y+25,stopPosition,0));
                        drawpanel.add(bullets.get(bullets.size()-1));
                        bullets.add(new bullet(x+25 ,y+25,stopPosition,1));
                        drawpanel.add(bullets.get(bullets.size()-1));
                        bullets.add(new bullet(x+25 ,y+25,stopPosition,2));
                        drawpanel.add(bullets.get(bullets.size()-1));
                        Firing=PWeapon[CurrentWeapon].Fire();
                        Fired=true; 
                        shotgunsound();
                        break;
                        
                    }
                }
                else {bullets.add(new bullet(x+25 ,y+25,stopPosition,0));
                drawpanel.add(bullets.get(bullets.size()-1));
                Firing=PWeapon[CurrentWeapon].Fire();
                Fired=true;
                gunsound();
                break;}
                }
            }
        }
       @Override
       public void keyReleased(KeyEvent ke) {
            // when releas key of arrows set its boolean false
            
                if(isAlive)
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
                case KeyEvent.VK_K :
                    Fired=false;
                    break;  
            }
       }
});
        
        }
        if (PlayerNumber==2){
        frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent ke) {
            // when press key of arrows set its boolean true 
            
            
                if(isAlive)
            switch (ke.getKeyCode()){
                case KeyEvent.VK_D :
                    right = true ;
                    break;
                case KeyEvent.VK_A :
                    left = true ;
                    break;    
                case KeyEvent.VK_W :
                    up = true ;
                    break;     
                case KeyEvent.VK_S :
                    down = true ;
                    break;  
                case KeyEvent.VK_1:
                    CurrentWeapon=0;
                    damage=PWeapon[CurrentWeapon].damage;
                    break;
                case KeyEvent.VK_2:
                    CurrentWeapon=1;
                    damage=PWeapon[CurrentWeapon].damage;
                    break;
                    
                case KeyEvent.VK_F:
                if(Fired==false){
                if(CurrentWeapon==1){
                    if(PWeapon[CurrentWeapon].ammo>0){
                        bullets.add(new bullet(x+25 ,y+25,stopPosition,0));
                        drawpanel.add(bullets.get(bullets.size()-1));
                        bullets.add(new bullet(x+25 ,y+25,stopPosition,1));
                        drawpanel.add(bullets.get(bullets.size()-1));
                        bullets.add(new bullet(x+25 ,y+25,stopPosition,2));
                        drawpanel.add(bullets.get(bullets.size()-1));
                        Firing=PWeapon[CurrentWeapon].Fire();
                        Fired=true;
                        shotgunsound();
                        break;
                        
                    }
                }
                else {bullets.add(new bullet(x+25 ,y+25,stopPosition,0));
                drawpanel.add(bullets.get(bullets.size()-1));
                Firing=PWeapon[CurrentWeapon].Fire();
                Fired=true;
                gunsound();
                break;}
                }
            }
        }
       @Override
       public void keyReleased(KeyEvent ke) {
            // when releas key of arrows set its boolean false
            if(isAlive)
            switch (ke.getKeyCode()){
                case KeyEvent.VK_D :
                    right = false ;
                    break;
                case KeyEvent.VK_A:
                    left = false ;
                    break;    
                case KeyEvent.VK_W :
                    up = false ;
                    break;     
                case KeyEvent.VK_S :
                    down = false ;
                    break;       
                case KeyEvent.VK_F :
                    Fired=false;
                    break;  
            }
       }
});}
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
    
    public void DamageHandling (){
        for(int i=0;i<bullets.size();i++){
            bullet temp = bullets.get(i);
            switch(temp.direction){
                case 7://right
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(50, 5);
                        else temp.MoveBulletBy(50, -5);
                    }
                    else temp.MoveBulletBy(50, 0);
                    break;
                case 8://left
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(-50, 5);
                        else temp.MoveBulletBy(-50, -5);
                    }
                    else temp.MoveBulletBy(-50, 0);
                    break;
                case 5://up
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(5, -50);
                        else temp.MoveBulletBy(-5, -50);
                    }
                    else temp.MoveBulletBy(0, -50);
                    break;
                case 6://down
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(5, 50);
                        else temp.MoveBulletBy(-5, 50);
                    }
                    else temp.MoveBulletBy(0, 50);
                    break;
                case 1://up and right
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(60, -50);
                        else temp.MoveBulletBy(40, -50);
                    }
                    else temp.MoveBulletBy(50, -50);
                    break;
                case 2://up and left
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(-60, -50);
                        else temp.MoveBulletBy(-40, -50);
                    }
                    else temp.MoveBulletBy(-50, -50);
                    break;
                case 3: //down and right
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(50, 60);
                        else temp.MoveBulletBy(60, 50);
                    }
                    else temp.MoveBulletBy(50, 50);
                    break;
                case 4: //down and left
                    if(temp.ShotgunBullet>0){
                        if(temp.ShotgunBullet==1)
                            temp.MoveBulletBy(-50, 60);
                        else temp.MoveBulletBy(-60, 50);
                    }
                    else temp.MoveBulletBy(-50, 50);
                    break;
            }
            //(Math.abs(temp.getWidth()-zombies.z.get(j).getWidth())>50*zombies.z.get(j).scale||Math.abs(temp.getHeight()-zombies.z.get(j).getHeight())>50*zombies.z.get(j).scale)
            bullets.set(i, temp);
            bullets.get(i).setLocation(temp.b.x,temp.b.y);
            for(int j=0;j<zombies.z.size();j++){
                if(((Math.abs(temp.getX()-zombies.z.get(j).getX())<=50*zombies.z.get(j).scale) && (Math.abs(temp.getY()-zombies.z.get(j).getY())<=50*zombies.z.get(j).scale))&&
                        (Math.abs(temp.getX())>Math.abs(zombies.z.get(j).getX()))&&(Math.abs(temp.getX())<Math.abs(zombies.z.get(j).getX()+zombies.z.get(j).CollX))&&(Math.abs(temp.getY())>Math.abs(zombies.z.get(j).getY()+zombies.z.get(j).space))&&(Math.abs(temp.getY())<Math.abs(zombies.z.get(j).getY()+zombies.z.get(j).CollY+zombies.z.get(j).space))){
                   try{
                    zombies.TakeDamage(j, damage);
                   bullets.remove(i);
                   drawpanel.remove(temp);
                   
                   }
                   catch(Exception ex){
                       System.out.println("none-critical Exception in Bullet Hitting Zombie:"+ex);
                   }
                   j=-1;
                   i=-1;
                   break;
                }
            }
            if((temp.b.getX()>mapdim.width+100)||(temp.b.getY()>mapdim.height+100)){
                    try{bullets.remove(i);
                    drawpanel.remove(temp);}
                    catch(Exception ex){
                        System.out.println("none-critical Exception in Bullet Leaving Frame:"+ex);
                    }
                }
        }
    }
    public void die(){
        this.isAlive=false;
        try {
           this.finalize();
       } catch (Throwable ex) {
           Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void animation (){
        // annimation of player
        if(isAlive){
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
        else{ // when player  not move 
            if(stopPosition  == 1)// Up and right
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/UpRight.png")));
           if(stopPosition  == 2)// up and left 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/UpLeft.png")));
           if(stopPosition  == 3) // down and right 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/DownRight.png")));
           if(stopPosition  == 4) // down amd left 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/DownLeft.png")));
           if(stopPosition  == 5) // up
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Soldier.png")));
           if(stopPosition  == 6) // down
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Down.png")));
           if(stopPosition  == 7) // right 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Right.png")));
           if(stopPosition  == 8) // left 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/Left.png")));
        }
        }
    }
    public void animation2 (){
         // annimation of player
        if(isAlive){
        if  (up && right){
        this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierUpRight2.gif")));
        stopPosition  = 1 ;
        }
        else if  (up && left){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierUpLeft2.gif")));
         stopPosition  = 2 ;
        } 
        else if  (down && right){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierDownRight2.gif")));
         stopPosition  = 3;
        }
        else if  (down && left){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierDownLeft2.gif")));
         stopPosition  = 4;
        }
        else if  (up){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierUp2.gif")));
         stopPosition  = 5;
        }
        else if  (down){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierDown2.gif")));
         stopPosition  = 6;
        }
        else if  (right){
        this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierRight2.gif")));
        stopPosition  = 7;
        }
        else if  (left){
         this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/SoldierLeft2.gif")));
         stopPosition  = 8 ;
        }
        else{ // when player  not move 
            if(stopPosition  == 1)// Up and right
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2UpRight.png")));
           if(stopPosition  == 2)// up and left 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2UpLeft.png")));
           if(stopPosition  == 3) // down and right 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2DownRight.png")));
           if(stopPosition  == 4) // down amd left 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2DownLeft.png")));
           if(stopPosition  == 5) // up
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2Up.png")));
           if(stopPosition  == 6) // down
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2Down.png")));
           if(stopPosition  == 7) // right 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2Right.png")));
           if(stopPosition  == 8) // left 
            this.setIcon(new ImageIcon(getClass().getResource("misc/Sprites/2Left.png")));
    
        }}
    }
    public void gunsound(){
        if(isAlive){
        try{
            File file = new File("gun_sound1.wav");
            Clip clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
            clip1.start();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    }
    public void shotgunsound(){
        
        if(isAlive){
        try{
            File file = new File("shotgun.wav");
            Clip clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
            clip1.start();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    }
}
