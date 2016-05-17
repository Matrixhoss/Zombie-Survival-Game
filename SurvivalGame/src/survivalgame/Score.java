
package survivalgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


class Score implements Serializable{
    public String name;
    public int Score;

    public Score() {
    }
    
    public Score(String name, int Score) {
        this.name = name;
        this.Score = Score;
    }

    @Override
    public String toString() {
        return "Name :"+this.name+", Score :"+this.Score; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
class TotalScore implements Serializable{
    public static LinkedList<Score> Total=new LinkedList();
    public int Size=0;
    boolean Added=false;
    
    public TotalScore() {
    
    }
    public boolean IsFull(){
        return Total.size()>=10;
    }
    
    public void addScore(String name,int Score){
        System.out.println(Size);
        if(!this.IsFull()){
        for(int i=0;i<Size;i++){
            if(Score>Total.get(i).Score){
                Total.add(i, new Score(name,Score));
                Size++;
                Added=true;
                break;
            }    
        }
        if(!Added){
            Total.add(new Score(name,Score));
            Size++;
//            System.out.println("add new Score");
        }
        }
        Added=false;
    }
    
    public void SaveScores(){
      try {
        FileOutputStream fos = new FileOutputStream("Score");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        
        oos.writeInt(Size);
        for(int i=0;i<Size;i++)
            oos.writeObject(Total.get(i));
        
        oos.close();
        fos.close();
        
       } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void ReadScores(){
      try{  
        FileInputStream fis = new FileInputStream("Score");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        Size=ois.readInt();
        Score s=new Score();
        for(int i=0;i<Size;i++){
            s=(Score)ois.readObject();
            Total.add(i, s);
        }
        ois.close();
        fis.close();
        
       } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TotalScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void PrintAll(){
        for(int i=0;i<Size;i++)
            System.out.println(Total.get(i));
    }
}
