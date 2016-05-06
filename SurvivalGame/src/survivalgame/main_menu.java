package survivalgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main_menu extends JFrame{
    public JLabel background;
    public JButton start;
    public JButton option;
    public JButton exit;
    public JLabel logo;
    ImageIcon main_menu_logo= new ImageIcon(getClass().getResource("logo.gif"));
    ImageIcon start_logo= new ImageIcon(getClass().getResource("logo.gif"));
    ImageIcon start_logo_button= new ImageIcon(getClass().getResource("logo.gif"));
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
    
    option = new JButton("Option");
    option.setBounds(310, 250, 200, 50);
    c.add(option);
    
    exit = new JButton("Exit");
    exit.setBounds(310, 320, 200, 50);
    c.add(exit);
    
    background = new JLabel(main_menu_logo);
    background.setBounds(0, 0, 800, 600);
    c.add(background);
    }
}
