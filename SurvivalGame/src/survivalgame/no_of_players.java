package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;
import java.applet.*;
import java.net.*;

public class no_of_players extends JFrame{
    private JLabel background;
    private JLabel logo;
    private JButton one;
    private JButton two;
    private JButton back;
    
    main_menu themenu;
    
    ImageIcon background_logo= new ImageIcon(getClass().getResource("misc/zm.png"));
    ImageIcon one_logo= new ImageIcon(getClass().getResource("misc/one_btn.png"));
    ImageIcon two_logo= new ImageIcon(getClass().getResource("misc/two_btn.png"));
    ImageIcon menu_logo= new ImageIcon(getClass().getResource("misc/no_players.png"));
    ImageIcon back_btn = new ImageIcon(getClass().getResource("misc/back.png"));
    
    public no_of_players(main_menu m){
        this.setSize(800, 600);
        this.setTitle("Choose Players");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        themenu=m;
        
        logo = new JLabel(menu_logo);
        logo.setBounds(100, 10, 600, 150);
        c.add(logo);
        
        one = new JButton(one_logo);
        one.setBackground(Color.BLACK);
        one.setBounds(50, 250, 283, 88);
        c.add(one);
        
        two = new JButton(two_logo);
        two.setBackground(Color.BLACK);
        two.setBounds(400, 250, 283, 88);
        c.add(two);
        
        back = new JButton(back_btn);
        back.setBounds(20, 450, 130, 75);
        back.setBackground(Color.BLACK);
        c.add(back);
        
        background = new JLabel(background_logo);
        background.setBounds(0, 0, 800, 600);
        c.add(background);
        
        one.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    choose_map fa = new choose_map();
                    fa.setVisible(true);
//                    player=JOptionPane.showInputDialog(null,"Enter Player Name: ");
                }
            }
        );
        two.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    choose_map_2 fa = new choose_map_2();
                    fa.setVisible(true);
//                    player=JOptionPane.showInputDialog(null,"Enter First Player Name: ");
//                    player=JOptionPane.showInputDialog(null,"Enter Second Player Name: ");
                }
            }
        );
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