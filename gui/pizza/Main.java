package pizza;

import javax.swing.JOptionPane;

public class Main {

    private static Pizza pie = new Pizza();
    private static Bill order = new Bill();
    private static Order process = new Order();

    public static void main(String[] args) {
        // Processing the toppings.
        String strToppings = process.chooseToppings();
        pie.setToppings(strToppings);

        // Processing the diameter.
        int intDiameter = process.enterDiameter();
        pie.setDiameter(intDiameter);

        // Processing the quantity.
        int intHowMany = process.howMany();
        pie.setHowMany(intHowMany);

        // Processing the discount.
        String strDiscount = process.chooseDiscount();
        pie.setDiscount(strDiscount);

        double dblTotal = order.displayBill(pie);

        // Processing the payment.
        while (true) {
            int intAmount = process.promptInput("Enter Amount:");

            if (intAmount > dblTotal) {
                JOptionPane.showMessageDialog(null, 
                                              "Your CHANGE is Php" 
                                              + (intAmount - dblTotal));

                JOptionPane.showMessageDialog(null, "Thank you!");
                System.exit(0);
            }

            JOptionPane.showMessageDialog(null, 
                                          "Insufficient Amount", 
                                          "Warning", 
                                          JOptionPane.WARNING_MESSAGE);
        }
    }

}