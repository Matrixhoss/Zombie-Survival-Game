
package survivalgame;


public  class Waves {
    private static int WaveNumber=1;
    public static void setWave(int x){
    WaveNumber=1;
    }
    
    public static void setNextWave(){
    Waves.WaveNumber+=1;
    }
    public static int getWave(){
    return WaveNumber;
    }
    public static int getPrevWave(){
    return WaveNumber-2;
    }
 
}
