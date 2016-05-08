package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;
import java.applet.*;
import java.net.*;

public class main_menu extends JFrame{
    public JLabel background;
    public JButton start;
    public JButton option;
    public JButton music;
    public JButton exit;
    public JLabel logo;
    ImageIcon main_menu_logo= new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon start_logo= new ImageIcon(getClass().getResource("misc/zm2.gif"));
    ImageIcon start_logo_button= new ImageIcon(getClass().getResource("misc/logo.gif"));
    ImageIcon option_button= new ImageIcon(getClass().getResource("misc/op.png"));
    ImageIcon exit_button= new ImageIcon(getClass().getResource("misc/ex.png"));
    ImageIcon music_button= new ImageIcon(getClass().getResource("misc/ms.png"));
    
    public main_menu(){
        this.setTitle("Glav Survival");
        this.setResizable(false);
        this.setBounds(0, 0, 800, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        
        logo = new JLabel(start_logo);
        logo.setBounds(200,0, 400, 200);
        c.add(logo);
        
        start = new JButton(start_logo_button);
        start.setBounds(310, 180, 200, 50);
        start.setBackground(Color.BLACK);
        c.add(start);
        
        option = new JButton(option_button);
        option.setBackground(Color.BLACK);
        option.setBounds(310, 250, 200, 50);
        c.add(option);
        
        music = new JButton(music_button);
        music.setBackground(Color.BLACK);
        music.setBounds(310, 320, 200, 50);
        c.add(music);
        
        exit = new JButton(exit_button);
        exit.setBackground(Color.BLACK);
        exit.setBounds(310, 390, 200, 50);
        c.add(exit);
   
        background = new JLabel();
        background.setIcon(main_menu_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        start.addActionListener(     
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    choose_map fa = new choose_map();
                    fa.setVisible(true);
                }
            }
        );
        
        option.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    diffculty df = new diffculty();
                    df.setVisible(true);
                }
            }
        );
        
//        music.addActionListener(
//            new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    try{
//                        File file = new File("Main Menu Theme.m4a");
//                        Clip clip1 = AudioSystem.getClip();
//                        clip1.open(AudioSystem.getAudioInputStream(file));
//                        clip1.start();
//                    }
//                    catch(Exception h){
//                        System.err.println(h.getMessage());
//                    }
//                }
//            }
//        );
                
        exit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            }
        );
    }
    public static void playback(){
        try{
            File file = new File("misc/Main Menu Theme.m4a");
            Clip clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
            clip1.start();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
