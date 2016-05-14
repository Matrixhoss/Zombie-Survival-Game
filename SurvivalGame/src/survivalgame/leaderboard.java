package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;
import java.applet.*;
import java.net.*;

public class leaderboard extends JFrame{
    private JLabel leaderboard;
    private JButton back;
    private JLabel background;
    
    ImageIcon background_logo = new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon back_btn = new ImageIcon(getClass().getResource("misc/back.png"));
    ImageIcon leaderborad_logo = new ImageIcon(getClass().getResource("misc/leader_board.png"));
    
    public leaderboard(){
        this.setSize(800, 600);
        this.setTitle("Hall Of Fame");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        Container c =this.getContentPane();
        c.setLayout(null);
        
        leaderboard = new JLabel(leaderborad_logo);
        leaderboard.setBounds(10, 0, 790, 170);
        c.add(leaderboard);
        
        back = new JButton(back_btn);
        back.setBounds(20, 450, 130, 75);
        back.setBackground(Color.BLACK);
        c.add(back);
        
        background = new JLabel(background_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        back.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    main_menu x= new main_menu();
                    x.setVisible(true);
                }
            }
        );
    }
}