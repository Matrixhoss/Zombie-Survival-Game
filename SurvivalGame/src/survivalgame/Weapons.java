package survivalgame;


public class Weapons {
     int damage;
     int rateoffire;
     int ammo;
     int range;
     int MAPSIZE=500;
     boolean burstfire;
    
}
 class Pistol extends Weapons{
    Pistol (){
         this.damage = 10;
         this.rateoffire=10;
         this.ammo=Integer.MAX_VALUE;
         this.range=this.MAPSIZE*(3/4);
         this.burstfire=false;
     }
 }
class UZI extends Weapons{
    UZI () {
        this.damage=5;
        this.rateoffire=50;
        this.ammo=500;
        this.range=this.MAPSIZE;
        this.burstfire=false;
    }
    
}
class SHOTGUN extends Weapons{
    SHOTGUN(){
        this.damage = 50;
        this.rateoffire = 5;
        this.ammo=30;
        this.range=this.MAPSIZE*(1/2);
        this.burstfire=true;
    }
}
class MELEE extends Weapons{
    MELEE(){
        this.damage = 10;
        this.rateoffire = 5;
        this.ammo=Integer.MAX_VALUE;
        this.range=0;
        this.burstfire=false;
    }
}
class MELEE2 extends Weapons{
    MELEE2(){
        this.damage = 20;
        this.rateoffire = 5;
        this.ammo=Integer.MAX_VALUE;
        this.range=0;
        this.burstfire=false;
    }
}
class MELEEFast extends Weapons{
    MELEEFast(){
        this.damage = 10;
        this.rateoffire = 20;
        this.ammo=Integer.MAX_VALUE;
        this.range=0;
        this.burstfire=false;
    }
}
