package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.*;

public class choose_map extends JFrame{
    private JLabel choose;
    private JLabel background;
    private JButton first_map;
    private JButton second_map;
    private JButton third_map;
    private JButton back;
    
    no_of_players players;
    
    ImageIcon background_img = new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon choose_btn = new ImageIcon(getClass().getResource("misc/cho.png"));
    ImageIcon first_map_btn = new ImageIcon(getClass().getResource("misc/Maps.png"));
    ImageIcon second_map_btn = new ImageIcon(getClass().getResource("misc/sass.png"));
    ImageIcon third_map_btn = new ImageIcon(getClass().getResource("misc/wds.png"));
    ImageIcon back_btn = new ImageIcon(getClass().getResource("misc/back.png"));
    
    public choose_map(no_of_players nop){
        this.setTitle("Choose map");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        players=nop;
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        choose = new JLabel(choose_btn);
        choose.setBounds(160, 10, 500, 100);
        c.add(choose);
        
        first_map = new JButton(first_map_btn);
        first_map.setBounds(50, 150, 200, 300);
        c.add(first_map);
        
        second_map = new JButton(second_map_btn);
        second_map.setBounds(300, 150, 200, 300);
        c.add(second_map);
        
        third_map = new JButton(third_map_btn);
        third_map.setBounds(550, 150, 200, 300);
        c.add(third_map);
        
        back = new JButton(back_btn);
        back.setBounds(20, 470, 130, 75);
        back.setBackground(Color.BLACK);
        c.add(back);
        
        background = new JLabel(background_img);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        first_map.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    All_map sa=new All_map(new ImageIcon(getClass().getResource("misc/map1.jpg"))){};
                    sa.setVisible(true);
                }
            }
        );
        
        second_map.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    All_map sn = new All_map(new ImageIcon(getClass().getResource("misc/Hillsides.png")));
                    sn.setVisible(true);
                }
            }
        );
        
        third_map.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    All_map se = new All_map(new ImageIcon(getClass().getResource("misc/wd.png")));
                    se.setVisible(true);
                }
            }
        );
        
        back.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    players.setVisible(true);
                }
            }
        );
    }
}