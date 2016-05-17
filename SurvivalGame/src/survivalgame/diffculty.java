package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;

public class diffculty extends JFrame{
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private JLabel choose_diff;
    private JLabel background;
    private JButton back;
    ImageIcon background_logo= new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon easy_btn= new ImageIcon(getClass().getResource("misc/easy.png"));
    ImageIcon medium_btn= new ImageIcon(getClass().getResource("misc/med.png"));
    ImageIcon hard_btn= new ImageIcon(getClass().getResource("misc/hard.png"));
    ImageIcon cyd_btn= new ImageIcon(getClass().getResource("misc/cyd.png"));
     ImageIcon back_btn = new ImageIcon(getClass().getResource("misc/back.png"));
    public diffculty(){
        this.setTitle("Difficulty");
        this.setLocation(300,70);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        choose_diff = new JLabel(cyd_btn);
        choose_diff.setBounds(50, 50, 700, 100);
        c.add(choose_diff);
        
        
        easy = new JButton(easy_btn);
        easy.setBounds(50, 220, 200, 100);
        easy.setBackground(Color.GREEN);
        c.add(easy);
        easy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                All_map.Difficulty=1;
                dispose();
            }
        });
        medium = new JButton(medium_btn);
        medium.setBounds(300, 220, 200, 100);
        medium.setBackground(Color.YELLOW);
        c.add(medium);
        medium.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                All_map.Difficulty=2;
                dispose();
            }
        });
        
        hard = new JButton(hard_btn);
        hard.setBounds(550, 220, 200, 100);
        hard.setBackground(Color.red);
        c.add(hard);
        hard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                All_map.Difficulty=3;
                dispose();
            }
        });
        
    
         back = new JButton(back_btn);
        back.setBounds(20, 470, 130, 75);
        back.setBackground(Color.BLACK);
        c.add(back);
        
         back.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    
                }
            }
        );
        
        background = new JLabel(background_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        
    }
}