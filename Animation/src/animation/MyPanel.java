/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author amol
 */
public class MyPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 482;
    final int PANEL_HEIGHT = 343;
    Image ghost;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 1;
    int x = 0, y = 0;
    
    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
//        this.setBackground(Color.black);
        
        ghost = new ImageIcon("Images/ghost.png").getImage();
        backgroundImage = new ImageIcon("Images/horror.jpg").getImage();
        timer = new Timer(20, this);
        timer.start();
        
    }
    
    public void paint(Graphics g){
        
        super.paint(g); 
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(ghost,x,y,null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(x>=PANEL_WIDTH-ghost.getWidth(null) ||  x<0  ){
            xVelocity *= -1;
        }              
        x = x + xVelocity;
        
        if(y>=PANEL_HEIGHT-ghost.getHeight(null) ||  y<0  ){
            yVelocity *= -1;
        }
        y = y + yVelocity;
        
        repaint();
        
    }
    
}
