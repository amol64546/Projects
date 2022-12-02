/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author amol
 */
public class GamePlay extends JPanel  implements KeyListener, ActionListener {
     private MapGenerator map;
    private int delay=8;
    private Timer timer;
    private int playerX=310;
    private int ballposX=120;
    private int ballposY=350;
    private int ballXdir=-1;
    private int ballYdir=-2;
    private boolean play = false;
    private int score = 0;
    private int totalbricks = 21;

    public GamePlay(){
        map = new MapGenerator(3,7);
        addKeyListener( this);
        setFocusable(true);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){

        //background
        g.setColor(Color.black);
        g.fillRect(0,0,700,600);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,600);
        g.fillRect(0,0,700,3);
        g.fillRect(697,0,3,600);

        //bricks
        map.draw((Graphics2D) g);

        //paddle
        g.setColor(Color.yellow);
        g.fillRect(playerX,550,100,8);

        //ball
        g.setColor(Color.green);
        g.fillOval(ballposX,ballposY,20,20);

        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+score, 590,30);

        // Game over
        if(ballposY>570){
            play = false;
            ballposX = 0;
            ballposY = 0;

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Scores: "+ score, 190, 300);

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press (Enter) to Restart", 230 , 350);

        }

        // Won
        if(totalbricks==0){
            play = false;
            ballposX = 0;
            ballposY = 0;

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won "+ score, 260, 300);

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press (Enter) to Restart", 230 , 350);

        }

        g.dispose();




    }





    public void moveLeft(){
        play = true;
        playerX -= 15;
    }

    public void moveRight(){
        play = true;
        playerX += 15;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if( playerX >= 600)
                playerX = 600;
            else
                moveRight();

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if( playerX < 10)
                playerX = 10;
            else
                moveLeft();

        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                  playerX=310;
                  ballposX=120;
                  ballposY=350;
                  ballXdir=-1;
                  ballYdir=-2;
                  score = 0;
                  totalbricks = 21;
                map = new MapGenerator(3,7);
                repaint();

            }

        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
                ballYdir = -ballYdir;

            A:
            for(int i=0; i<map.map.length; i++){
                for(int j=0; j<map.map[0].length; j++){
                    if(map.map[i][j] > 0){
                        int brickWidth  = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        int brickX = j*brickWidth+80;
                        int brickY = i*brickHeight+50;

                        Rectangle brickrect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballrect = new Rectangle(ballposX,ballposY,20,20);

                        if(ballrect.intersects(brickrect)){
                            map.setBrickValue(0,i,j);
                            totalbricks--;
                            score += 5;
                            if(ballposX+19 <= brickrect.x || ballposX+1 >= brickrect.x+brickWidth)
                                ballXdir = -ballXdir;
                            else
                                ballYdir = -ballYdir;
                            break A;
                        }


                    }
                }
            }

            ballposX += ballXdir;
            ballposY += ballYdir;

            if(ballposX<3 || ballposX>677)
                ballXdir = -ballXdir;
            if(ballposY<3)
                ballYdir = -ballYdir;

        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
