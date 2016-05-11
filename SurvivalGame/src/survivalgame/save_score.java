package survivalgame;

import java.io.*;

public class save_score {
    public save_score(){
        File newfile = new File("misc/highscore.txt");
        if(newfile.exists()){
            System.out.println("Rename the file");
        }
        else{
            try{
                newfile.createNewFile();
            }
            catch(Exception e){
                System.err.println("Error");
            }
            try{
                FileWriter score_file = new FileWriter(newfile);
                BufferedWriter score_buff = new BufferedWriter(score_file);
                //Th new score of the user
                score_buff.write(ZombieGenerator.score);
                score_buff.close();
            }
            catch(Exception e){
                System.err.println("Error");
            }
        }
    }
}