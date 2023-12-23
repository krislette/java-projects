package calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public StringBuilder strCalculation;
    public JTextField txtDisplay;

    // Constructor for the Calculator class.
    public Calculator() {
        super("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creates a StringBuilder object to store the user input.
        strCalculation = new StringBuilder();

        txtDisplay = new JTextField("");
        txtDisplay.setEditable(false);
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);

        Font txtDisplayFont = txtDisplay.getFont().deriveFont(Font.PLAIN, 20);
        txtDisplay.setFont(txtDisplayFont);
        txtDisplay.setPreferredSize(new Dimension(300, 50));

        add(txtDisplay, BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    // Method for creating the button panel.
    public JPanel createButtonPanel() {
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(5, 4, 5, 5));

        String[] arrButtons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "Clear"
        };

        // Creates all buttons, adds them to the panel and adds an action listener.
        for (String strButton : arrButtons) {
            JButton btnNewButton = new JButton(strButton);
            btnNewButton.addActionListener(new Listener(this));
            pnlButtons.add(btnNewButton);
        }

        return pnlButtons;
    }

    // Method for updating the calculation based on the user button clicks.
    public void updateCalculation(String userInput) {
        strCalculation.append(userInput);
        txtDisplay.setText(strCalculation.toString());
    }

    // Method for evaluating the expression when the equals button is clicked.
    public void evaluateExpression() {
        try {
            double dblResult = evaluateCalculation(strCalculation.toString());
            txtDisplay.setText(String.valueOf(dblResult));
            strCalculation.setLength(0);
            strCalculation.append(dblResult);
        } catch (ArithmeticException | IllegalArgumentException ex) {
            txtDisplay.setText("Error");
            strCalculation.setLength(0);
        }
    }

    // Method for evaluating the string which contains the calculation.
    public double evaluateCalculation(String strCalculation) {
        String[] arrExpressions = strCalculation.split("(?=[-+*/])|(?<=[-+*/])");
        double dblResult = Double.parseDouble(arrExpressions[0]);
        char chrCurrentOperator = ' ';

        // Loops through the array of expressions and performs the calculation.
        for (String strExpression : arrExpressions) {
            if (strExpression.matches("[+-/*]")) {
                chrCurrentOperator = strExpression.charAt(0);
            } else {
                double dblOperand = Double.parseDouble(strExpression);

                switch (chrCurrentOperator) {
                    case '+':
                        dblResult += dblOperand;
                        break;
                    case '-':
                        dblResult -= dblOperand;
                        break;
                    case '*':
                        dblResult *= dblOperand;
                        break;
                    case '/':
                        if (dblOperand != 0) dblResult /= dblOperand;
                        else throw new ArithmeticException("Cannot divide by zero");
                        break;
                    default:
                        dblResult = dblOperand;
                        break;
                }
            }
        }

        return dblResult;
    }

    // Method for clearing the display.
    public void clearDisplay() {
        strCalculation.setLength(0);
        txtDisplay.setText("");
    }

}