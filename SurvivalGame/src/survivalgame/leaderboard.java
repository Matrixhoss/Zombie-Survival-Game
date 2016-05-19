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
    private JTextArea score_field;
    private JLabel ground;
    
    main_menu themenu;
    
    ImageIcon background_logo = new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon back_btn = new ImageIcon(getClass().getResource("misc/back.png"));
    ImageIcon leaderborad_logo = new ImageIcon(getClass().getResource("misc/leader_board.png"));
    ImageIcon ground_logo = new ImageIcon(getClass().getResource("misc/aqw.png"));
    
    
    public leaderboard(main_menu m){
        
        themenu = m;
        this.setLocation(300,70);
        this.setSize(800, 600);
        this.setTitle("Hall Of Fame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        
        ground = new JLabel(ground_logo);
        ground.setBounds(670, 450, 100, 99);
        c.add(ground);
        
        score_field = new JTextArea();
        score_field.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        score_field.setBounds(130, 140, 550, 300);
        score_field.setBackground(Color.BLACK);
        score_field.setEditable(false);
        score_field.setFont(new Font("Stencil Regular", Font.ITALIC, 20));
        score_field.setForeground(Color.WHITE);
        for(int i=0;i<10;i++){
            score_field.setText(score_field.getText()+"\n"+main_menu.l.Total.get(i));
        }
        c.add(score_field);
        
        background = new JLabel(background_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        back.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    themenu.setVisible(true);
                }
            }
        );
    }
}