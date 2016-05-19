package survivalgame;


public abstract class Weapons {
     int damage;
     int rateoffire;
     int ammo;
     int range;
     
    public void RefillAmmo(){};
    public boolean Fire(){
        this.ammo--;
        return true;
    }
    
}
 class Pistol extends Weapons{
    Pistol (){
        super();
         this.damage = 10;
         this.rateoffire=10;
         this.ammo=Integer.MAX_VALUE;
         this.range=3;
     }
 }
class UZI extends Weapons{
    UZI () {
        this.damage=5;
        this.rateoffire=50;
        this.ammo=500;
        this.range=1;
    }
    
}
class Shotgun extends Weapons{
    Shotgun(){
        this.damage = 50;
        this.rateoffire = 5;
        this.ammo=10;
        this.range=2;
    }
    @Override
    public void RefillAmmo(){this.ammo=10;};
    
    public void AddAmmo(int ammo){
        this.ammo+=ammo;
    }
}
class MELEE extends Weapons{
    MELEE(){
        this.damage = 10;
        this.rateoffire = 5;
        this.ammo=Integer.MAX_VALUE;
        this.range=0;
    }
}
class MELEE2 extends Weapons{
    MELEE2(){
        this.damage = 20;
        this.rateoffire = 5;
        this.ammo=Integer.MAX_VALUE;
        this.range=0;
    }
}
class MELEEFast extends Weapons{
    MELEEFast(){
        this.damage = 10;
        this.rateoffire = 20;
        this.ammo=Integer.MAX_VALUE;
        this.range=0;
    }
}
