import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
Random random = new Random();
JFrame frame = new JFrame();
JPanel title_panel = new JPanel();
JPanel button_panel = new JPanel();
JLabel textfield = new JLabel();
JButton[] buttons = new JButton[9]; // skapar en array av 9 knappar
boolean player1_turn;
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

    }
public void actionPreformed (ActionEvent e){

}

public void firstTurn(){

}
public void check(){

}
public void xWins(int a, int b, int c){

}
    public void oWins(int a, int b, int c){

    }
}
