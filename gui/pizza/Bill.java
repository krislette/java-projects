package pizza;

import javax.swing.JOptionPane;

public class Bill {

    // Method for displaying the bill using a dialog box.
    public double displayBill(Pizza PIE) {
        JOptionPane.showMessageDialog(null, "You ordered for " 
                                      + PIE.getToppings()
                                      + " Pizza\nwith the size of " 
                                      + PIE.getDiameter()
                                      + " centimeter(s)\n"
                                      + "for the total price of PHP" 
                                      + PIE.getPrice());

        return PIE.getPrice();
    }

}