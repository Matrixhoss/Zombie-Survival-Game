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
    ImageIcon first_map_btn = new ImageIcon(getClass().getResource(""));
    ImageIcon second_map_btn = new ImageIcon(getClass().getResource(""));
    ImageIcon third_map_btn = new ImageIcon(getClass().getResource(""));
    
    public choose_map(){
        this.setTitle("Choose map");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        choose = new JLabel();
        choose.setBounds(200, 100, 200, 200);
        c.add(choose);
        
        background = new JLabel(background_img);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
    }
}