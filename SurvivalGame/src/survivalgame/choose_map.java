package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;

public class choose_map extends JFrame{
    private JLabel choose;
    private JLabel background;
    private JButton first_map;
    private JButton second_map;
    private JButton third_map;
    ImageIcon background_img = new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon choose_btn = new ImageIcon(getClass().getResource("misc/cho.png"));
    ImageIcon first_map_btn = new ImageIcon(getClass().getResource("misc/Map.jpg"));
    ImageIcon second_map_btn = new ImageIcon(getClass().getResource("misc/dre.jpg"));
    ImageIcon third_map_btn = new ImageIcon(getClass().getResource("msic/wd.jpg"));
    
    public choose_map(){
        this.setTitle("Choose map");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        
        background = new JLabel(background_img);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
    }
}