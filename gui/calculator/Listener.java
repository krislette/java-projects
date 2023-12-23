package calculator;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    // Creates a Calculator object.
    private Calculator calculator;

    // Constructor for the Listener class.
    public Listener(Calculator calculator) {
        this.calculator = calculator;
    }

    // Method for handling button clicks.
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();
        String strButtonText = btnClicked.getText();

        // Switch statement for handling the different button clicks.
        switch (strButtonText) {
            case "=":
                calculator.evaluateExpression();
                break;
            case "Clear":
                calculator.clearDisplay();
                break;
            default:
                calculator.updateCalculation(strButtonText);
        }
    }

}