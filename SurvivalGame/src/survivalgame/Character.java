package survivalgame;

import javax.swing.JLabel;

public abstract class Character extends JLabel {
    
    private int speed;
    private int health;
    
    public  Character(int s ,int h){
    this.speed=s;
    this.health=h;
    }
  
    public void move(){};
    public void die(){};
    public void takeDamage(int d){health-=d;};
    public void setWeapon(){};
    
    public int getHealth(){return this.health;};
    
    public void setHealth(int h){
    this.health=h;
    }
    
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int s){
    this.speed=s;
    }
}
