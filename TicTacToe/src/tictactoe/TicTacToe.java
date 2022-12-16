/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author amol
 */


public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
   
    boolean player1_turn;
    
    TicTacToe() throws InterruptedException{
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setBounds(400, 160, 500, 500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(144, 238, 144));
        textfield.setFont(new Font("New Day",Font.BOLD,30));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,500,40);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        
        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
    
        frame.add(button_panel);
        
        firstTurn();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        for(int  i=0; i<9; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("0 turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("0");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() throws InterruptedException {
        Thread.sleep(2000);
        
        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("X turn");
        }else{
            player1_turn = false;
            textfield.setText("0 turn");
        }
    }
    
    public void check(){
        // check X win conditions
        if( (buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            XWins(0,1,2);
        }
        if( (buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            XWins(3,4,5);
        }
        if( (buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            XWins(6,7,8);
        }
        if( (buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            XWins(0,3,6);
        }
        if( (buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            XWins(1,4,7);
        }
        if( (buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            XWins(2,5,8);
        }
        if( (buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            XWins(0,4,8);
        }
        if( (buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            XWins(2,4,6);
        }
        
        
        // check 0 win conditions
        if( (buttons[0].getText()=="0") && (buttons[1].getText()=="0") && (buttons[2].getText()=="0")){
            OWins(0,1,2);
        }
        if( (buttons[3].getText()=="0") && (buttons[4].getText()=="0") && (buttons[5].getText()=="0")){
            OWins(3,4,5);
        }
        if( (buttons[6].getText()=="0") && (buttons[7].getText()=="0") && (buttons[8].getText()=="0")){
            OWins(6,7,8);
        }
        if( (buttons[0].getText()=="0") && (buttons[3].getText()=="0") && (buttons[6].getText()=="0")){
            OWins(0,3,6);
        }
        if( (buttons[1].getText()=="0") && (buttons[4].getText()=="0") && (buttons[7].getText()=="0")){
            OWins(1,4,7);
        }
        if( (buttons[2].getText()=="0") && (buttons[5].getText()=="0") && (buttons[8].getText()=="0")){
            OWins(2,5,8);
        }
        if( (buttons[0].getText()=="0") && (buttons[4].getText()=="0") && (buttons[8].getText()=="0")){
            OWins(0,4,8);
        }
        if( (buttons[2].getText()=="0") && (buttons[4].getText()=="0") && (buttons[6].getText()=="0")){
            OWins(2,4,6);
        }
        
        // check for draw
        int count=0;
        for(int i=0; i<9; i++){
            if(buttons[i].getText()!=""){
                count++;
            }
        }
        if(count==9){
            draw();
        }
        
    }

    private void XWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);            
        }
        
        textfield.setText("X wins");
    }
    private void OWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);            
        }
        
        textfield.setText("O wins");
    }
    
    private void draw(){
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);            
        }
        
        textfield.setText("Game is draw");
    }
    
    
    
}
