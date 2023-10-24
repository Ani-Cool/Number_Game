import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI {
    private JFrame frame;
    private JTextField inputField;
    private JButton guessButton;
    private JTextArea resultArea;
    private Random rand;
    private int randomNumber;
    private int tryCount;

    public NumberGuessingGameGUI() {
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        tryCount = 0;

        resultArea = new JTextArea(8, 20);
        resultArea.setEditable(false);
        frame.add(resultArea);

        inputField = new JTextField(10);
        frame.add(inputField);

        guessButton = new JButton("Guess");
        frame.add(guessButton);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        frame.setVisible(true);
    }

    private void checkGuess() {
        tryCount++;
        int playerGuess = Integer.parseInt(inputField.getText());

        if (playerGuess == randomNumber) {
            resultArea.append("Correct! You Win!\n");
            resultArea.append("It took you " + tryCount + " tries\n");
            inputField.setEditable(false);
            guessButton.setEnabled(false);
        } else if (randomNumber > playerGuess) {
            resultArea.append("Nope! The number is higher. Guess again.\n");
        } else {
            resultArea.append("Nope! The number is lower. Guess again.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGameGUI();
            }
        });
    }
}
