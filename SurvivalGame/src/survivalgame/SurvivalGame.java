package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;

public class SurvivalGame {
    public static void main(String[] args) throws Exception{
        main_menu mm = new main_menu();
        mm.setVisible(true);
        File soundFile = new File("C:\\Users\\User\\Desktop\\Project\\asuprogrammingproject\\SurvivalGame\\src\\survivalgame\\misc\\Theme.m4a");
        AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(sound);

        clip.addLineListener(new LineListener() {
            public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.STOP) {
                event.getLine().close();
                System.exit(0);
            }
            }
        });
        clip.start();
  }
}