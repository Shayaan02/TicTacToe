import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private boolean isXTurn = true;

    public TicTacToe() {
        frame = new JFrame("Tic Tac Toe");

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Times New Roman", Font.PLAIN, 100));
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void checkForWinner() {

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (isXTurn) {
            button.setText(" X ");
        }
        if (!isXTurn) {
            button.setText(" O ");
        }
        button.setEnabled(false);
        isXTurn = !isXTurn;

        checkForWinner();
    }
}
