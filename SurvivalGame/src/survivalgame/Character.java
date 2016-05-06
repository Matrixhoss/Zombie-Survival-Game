package survivalgame;

public abstract class Character {
    
    private int speed;
    private int health;
    private Weapons weapon;
    
    public Character(int s ,int h, Weapons W){
    this.speed=s;
    this.health=h;
    this.weapon=W;
    }
    
    public void move(){};
    public void die(){};
    public void takeDamage(){};
    public void setWeapon(){};
    
    
}