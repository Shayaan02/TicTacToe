import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JButton[][] buttons = new JButton[3][3]; // Use a 2D array
    private final JLabel textfield = new JLabel();
    private boolean isXTurn = true;
    private final Random random = new Random();
    private boolean AIEnabled = false;

    public TicTacToe() {
        frame = new JFrame("Tic Tac Toe");
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) { // Kollar igenom raderna
            for (int j = 0; j < 3; j++) { // Kollar igenom kollumner
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 100));
                panel.add(buttons[i][j]);
            }
        }

        JPanel buttonPanel = new JPanel();
        JButton turnOnAI = new JButton("Turn on AI");
        turnOnAI.addActionListener(e -> toggleAI());
        buttonPanel.add(turnOnAI);

        frame.add(textfield, BorderLayout.SOUTH);
        frame.add(turnOnAI, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void checkForWinner() {
        // Kollar X och O win conditions
        if (buttons[0][0].getText().equals(" X ") && buttons[0][1].getText().equals(" X ") && buttons[0][2].getText().equals(" X ")) {
            xWins(0, 1, 2);
        }
        if (buttons[1][0].getText().equals(" X ") && buttons[1][1].getText().equals(" X ") && buttons[1][2].getText().equals(" X ")) {
            xWins(3, 4, 5);
        }
        if (buttons[2][0].getText().equals(" X ") && buttons[2][1].getText().equals(" X ") && buttons[2][2].getText().equals(" X ")) {
            xWins(6, 7, 8);
        }
        if (buttons[0][0].getText().equals(" X ") && buttons[1][0].getText().equals(" X ") && buttons[2][0].getText().equals(" X ")) {
            xWins(0, 3, 6);
        }
        if (buttons[0][1].getText().equals(" X ") && buttons[1][1].getText().equals(" X ") && buttons[2][1].getText().equals(" X ")) {
            xWins(1, 4, 7);
        }
        if (buttons[0][2].getText().equals(" X ") && buttons[1][2].getText().equals(" X ") && buttons[2][2].getText().equals(" X ")) {
            xWins(2, 5, 8);
        }
        if (buttons[0][0].getText().equals(" X ") && buttons[1][1].getText().equals(" X ") && buttons[2][2].getText().equals(" X ")) {
            xWins(0, 4, 8);
        }
        if (buttons[0][2].getText().equals(" X ") && buttons[1][1].getText().equals(" X ") && buttons[2][0].getText().equals(" X ")) {
            xWins(2, 4, 6);
        }
        // Check O win conditions
        if (buttons[0][0].getText().equals(" O ") && buttons[0][1].getText().equals(" O ") && buttons[0][2].getText().equals(" O ")) {
            oWins(0, 1, 2);
        }
        if (buttons[1][0].getText().equals(" O ") && buttons[1][1].getText().equals(" O ") && buttons[1][2].getText().equals(" O ")) {
            oWins(3, 4, 5);
        }
        if (buttons[2][0].getText().equals(" O ") && buttons[2][1].getText().equals(" O ") && buttons[2][2].getText().equals(" O ")) {
            oWins(6, 7, 8);
        }
        if (buttons[0][0].getText().equals(" O ") && buttons[1][0].getText().equals(" O ") && buttons[2][0].getText().equals(" O ")) {
            oWins(0, 3, 6);
        }
        if (buttons[0][1].getText().equals(" O ") && buttons[1][1].getText().equals(" O ") && buttons[2][1].getText().equals(" O ")) {
            oWins(1, 4, 7);
        }
        if (buttons[0][2].getText().equals(" O ") && buttons[1][2].getText().equals(" O ") && buttons[2][2].getText().equals(" O ")) {
            oWins(2, 5, 8);
        }
        if (buttons[0][0].getText().equals(" O ") && buttons[1][1].getText().equals(" O ") && buttons[2][2].getText().equals(" O ")) {
            oWins(0, 4, 8);
        }
        if (buttons[0][2].getText().equals(" O ") && buttons[1][1].getText().equals(" O ") && buttons[2][0].getText().equals(" O ")) {
            oWins(2, 4, 6);
        }
        // kollar om om det är lika efter att ha kollat igenom alla win conditions
        if (isBoardFull() && !isXTurn) {
            draw();
        }
    }

    public void xWins(int a, int b, int c) {
        JOptionPane.showMessageDialog(frame, "X Wins");
        disableAllButtons();
        textfield.setText("X Wins");
        restartGame();
    }

    public void oWins(int a, int b, int c) {
       /* buttons[a][0].setBackground(Color.GREEN);
        buttons[b][1].setBackground(Color.GREEN);
        buttons[c][2].setBackground(Color.GREEN);*/
        JOptionPane.showMessageDialog(frame, "O Wins!");
        disableAllButtons();
        textfield.setText("O Wins");
        restartGame();
    }

    private void toggleAI() {
        AIEnabled = !AIEnabled;
        restartGame();
    }

    private void aiMove() {
        if (AIEnabled && !isXTurn) {
            int row, col;
            do {
                row = random.nextInt(3);
                col = random.nextInt(3);
            } while (!buttons[row][col].isEnabled());

            buttons[row][col].setText(" O ");
            buttons[row][col].setEnabled(false);
            isXTurn = true;
            checkForWinner();
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (isXTurn) {
            button.setText(" X ");
        } else {
            button.setText(" O ");
        }
        button.setEnabled(false);
        isXTurn = !isXTurn;

        checkForWinner();
        aiMove();
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void draw() {
        JOptionPane.showMessageDialog(frame, "Draw!");
        textfield.setText("Draw!");
        disableAllButtons();
        restartGame();
    }

    private boolean isBoardFull() { // kollar om brädan är full
        for (int i = 0; i < 3; i++) { // kollar igenom alla rader
            for (int j = 0; j < 3; j++) { // kollar igenom alla kollumner
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void restartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(null);
            }
        }
        isXTurn = true; // Reset the turn to X
        textfield.setText(""); // Clear the status text
    }
}