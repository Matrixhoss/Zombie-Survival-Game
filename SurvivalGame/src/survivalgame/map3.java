package survivalgame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static survivalgame.main_menu.x;
 
public class map3{
    private ImageIcon MapIcn;
    
    public map3(){
    MapIcn= new ImageIcon(getClass().getResource("misc/dre.png"));
    All_map m3=new All_map(MapIcn);
    m3.setVisible(true);}
}