
package survivalgame;


public  class Waves {
    private static int WaveNumber;
    
    public static void setNextWave(){
    Waves.WaveNumber+=1;
    }
    public int getWave(){
    return Waves.WaveNumber;
    }
 
}
