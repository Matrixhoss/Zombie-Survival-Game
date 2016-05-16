package survivalgame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static survivalgame.main_menu.x;

public class map2{
    private ImageIcon MapIcn;
    
    public map2(){
    MapIcn= new ImageIcon(getClass().getResource("misc/Hillsides.png"));
    All_map m2=new All_map(MapIcn);
    m2.setVisible(true);}
}