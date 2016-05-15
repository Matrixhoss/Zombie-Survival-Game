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
    public Clip clip1;
    public JLabel background;
    public JButton start;
    public JButton option;
    public JButton music;
    public JButton exit;
    public JButton hall_of_fame;
    public JLabel logo;
    private static String player;
    ImageIcon main_menu_logo= new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon start_logo= new ImageIcon(getClass().getResource("misc/zm2.gif"));
    ImageIcon start_logo_button= new ImageIcon(getClass().getResource("misc/logo.gif"));
    ImageIcon option_button= new ImageIcon(getClass().getResource("misc/op.png"));
    ImageIcon exit_button= new ImageIcon(getClass().getResource("misc/ex.png"));
    ImageIcon music_button= new ImageIcon(getClass().getResource("misc/ms.png"));
    ImageIcon hall_fame= new ImageIcon(getClass().getResource("misc/hall_of_fame.png"));
    public static int x=1;
    
    void openLeaderBoard()
    {
        this.setVisible(false);
        leaderboard x = new leaderboard(this);            
        x.setVisible(true);
        
    }
    void openno_of_players(){
        this.setVisible(false);
        no_of_players n = new no_of_players(this);
        n.setVisible(true);
    }
    public main_menu(){
        this.setTitle("Zombie Apocalypse");
        this.setResizable(false);
        this.setBounds(0, 0, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        
        this.playback();
                
        logo = new JLabel(start_logo);
        logo.setBounds(200,0, 400, 200);
        c.add(logo);
        
        start = new JButton(start_logo_button);
        start.setBounds(310, 180, 200, 50);
        start.setBackground(Color.BLACK);
        c.add(start);
        
        hall_of_fame = new JButton(hall_fame);
        hall_of_fame.setBackground(Color.BLACK);
        hall_of_fame.setBounds(310, 250, 200, 50);
        c.add(hall_of_fame);
        
        option = new JButton(option_button);
        option.setBackground(Color.BLACK);
        option.setBounds(310, 320, 200, 50);
        c.add(option);
        
        music = new JButton(music_button);
        music.setBackground(Color.BLACK);
        music.setBounds(310, 390, 200, 50);
        c.add(music);
        
        exit = new JButton(exit_button);
        exit.setBackground(Color.BLACK);
        exit.setBounds(310, 460, 200, 50);
        c.add(exit);
   
        background = new JLabel();
        background.setIcon(main_menu_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        start.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openno_of_players();
                }
            }
        );
        
        hall_of_fame.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openLeaderBoard();
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
        
        music.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(clip1.isRunning())
                        clip1.stop();
                    else clip1.start();
                }
            }
        );
                
        exit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            }
        );
    }
    public void playback(){
        try{
            if(x==1){
                File file = new File("Menu_Theme.wav");
                clip1 = AudioSystem.getClip();
                clip1.open(AudioSystem.getAudioInputStream(file));
                clip1.loop(Clip.LOOP_CONTINUOUSLY);
                clip1.start();
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}