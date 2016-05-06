package survivalgame;

import javax.swing.JLabel;

public abstract class Character extends JLabel {
    
    private int speed;
    private int health;
    private Weapons weapon;
    
    public  Character(int s ,int h, Weapons W){
    this.speed=s;
    this.health=h;
    this.weapon=W;
    }
     public  Character(int s ,int h){
    this.speed=s;
    this.health=h;
    
    }

    
    
    public void setHealth(){};
    public void move(){};
    public void die(){};
    public void takeDamage(int d){};
    public void setWeapon(){};
    
    public int getHealth(){return this.health;};
    
    public void sethealth(int h){
    this.health=h;
    }
    
    public void setWeapon(Weapons w){
    this.weapon=w;
    }
    
    public Weapons getWeapon(){
    return this.weapon;
    }  public int getSpeed(){
        return speed;
    }
    public int getSpeed(){
        return speed;
    }
}
