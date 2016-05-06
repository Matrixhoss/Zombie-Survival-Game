package survivalgame;

public abstract class Character {
    
    private int speed;
    private int health;
    private Weapons weapon;
    
    public  Character(int s ,int h, Weapons W){
    this.speed=s;
    this.health=h;
    this.weapon=W;
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
    }
}
