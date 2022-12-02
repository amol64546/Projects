/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

/**
 *
 * @author amol
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

     JFrame frame;
     JTextField textfield;
     JPanel panel;
     JButton[] numButtons = new JButton[10];
     JButton[] funButtons = new JButton[9];
     JButton add, sub, mul, div, neg, clr, dec, equ, del;
     Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);




        //function buttons
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equ = new JButton("=");

        del = new JButton("Del");
        clr = new JButton("CLR");
        neg = new JButton("(-)");
        neg.setBounds(50, 430, 100, 50);
        del.setBounds(150, 430, 100, 50);
        clr.setBounds(250, 430, 100, 50);

        funButtons[0] = add;
        funButtons[1] = sub;
        funButtons[2] = mul;
        funButtons[3] = div;
        funButtons[4] = dec;
        funButtons[5] = equ;
        funButtons[6] = del;
        funButtons[7] = clr;
        funButtons[8] = neg;

        for (int i = 0; i < 9; i++) {
            funButtons[i].addActionListener(this);
            funButtons[i].setFont(myFont);
            funButtons[i].setFocusable(false);
        }

        // number buttons
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }


        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // add to 4*4 grid
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(add);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(sub);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numButtons[0]);
        panel.add(equ);
        panel.add(div);


        frame.add(panel);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(textfield);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numButtons[i])
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
        if(e.getSource() == dec)
            textfield.setText(textfield.getText().concat("."));
        if(e.getSource() == neg){
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == clr)
            textfield.setText("");

        if(e.getSource() == del){
            String str = textfield.getText();
            textfield.setText("");
            for(int i=0; i<str.length()-1; i++){
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }

        if(e.getSource() == add){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == sub){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource() == mul){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource() == div){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if(e.getSource() == equ){
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                   result = num1 + num2;
                   break;
                case '-':
                   result = num1 - num2;
                   break;
                case '*':
                   result = num1 * num2;
                   break;
                case '/' :
                   result = num1 / num2;
                   
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }





    }


    public static void main(String[] args) {
         Calculator calculator = new Calculator();
    }
}
