package calculator;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Shows a dialog box with a welcome message.
        JOptionPane.showMessageDialog(null, 
                                      "Welcome to my Calculator (:", 
                                      "Welcome", 
                                      JOptionPane.INFORMATION_MESSAGE);

        // Creates a new instance of the calculator and makes it visible.
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
        calculator.setResizable(false);
    }

}