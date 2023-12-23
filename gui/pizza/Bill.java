package pizza;

import javax.swing.JOptionPane;

public class Bill {

    // Method for displaying the bill using a dialog box.
    public double displayBill(Pizza pie) {
        JOptionPane.showMessageDialog(null, "You ordered for " 
                                      + pie.getToppings()
                                      + " Pizza\nwith the size of " 
                                      + pie.getDiameter()
                                      + " centimeter(s)\n"
                                      + "for the total price of PHP" 
                                      + pie.getPrice());

        return pie.getPrice();
    }

}