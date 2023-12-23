package pizza;

import javax.swing.JOptionPane;

public class Order {

    private String[] arrToppings = {"", "Pepperoni", "Ham and Cheese", "Hawaiian"};
    private int[] arrPrices = {0, 100, 150, 200};

    // Method for choosing the pizza's toppings.
    public String chooseToppings() {
        // Loop will continue until the user chooses toppings or cancels the order.
        while (true) {
            String[] arrToppings = {"", "Pepperoni", "Ham and Cheese", "Hawaiian"};

            String strToppingsChoice = (String) JOptionPane.showInputDialog(null, "Choose Toppings", 
                                                                            "Pizza Program", 
                                                                            JOptionPane.QUESTION_MESSAGE, 
                                                                            null, arrToppings, 
                                                                            arrToppings[0]);

            // Handles the cancel button for this specific dialog box.
            if (strToppingsChoice == null) {
                cancelOrder();
                continue;
            }

            // Block of code for handling toppings choice from the user.
            if (strToppingsChoice.equals(arrToppings[0])) {
                JOptionPane.showMessageDialog(null, "Choose toppings!", "Reminder", 
                                              JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You chose "
                                              + strToppingsChoice 
                                              + "\nwhich cost additional " 
                                              + arrPrices[getPriceIndex(strToppingsChoice)] 
                                              + "php!");

                // Confirmation dialog box for the user's chosen toppings.
                String strMessage = "Are you sure?\nYou want " + strToppingsChoice + "?";
                if (promptConfirm(strMessage) == JOptionPane.YES_OPTION) return strToppingsChoice;
            }
        }
    }

    // Method for entering the pizza's diameter.
    public int enterDiameter() {
        return promptInput("Enter Diameter in inches");
    }

    // Method for entering the pizza's quantity.
    public int howMany() {
        return promptInput("Enter How Many?");
    }

    // Method for choosing the discount.
    public String chooseDiscount() {
        while (true) {
            String[] arrDiscountList = {"N/A", "Senior-PWD", "VIP"};

            int intDiscount = JOptionPane.showOptionDialog(null, "Choose Discount:", "Pizza Program", 
                                                           JOptionPane.DEFAULT_OPTION, 
                                                           JOptionPane.QUESTION_MESSAGE, null, 
                                                           arrDiscountList, arrDiscountList[0]);

            // If the user clicks a discount that is not "N/A", this will be executed.
            if (intDiscount != 0) {
                promptInput("Enter " + arrDiscountList[intDiscount] + " Card Number:");
            }

            return arrDiscountList[intDiscount];
        }
    }

    // Helper method for finding the corresponding index of the price of a topping.
    public int getPriceIndex(String strToppings) {
        for (int i = 0; i < arrToppings.length; i++) {
            if (arrToppings[i].equals(strToppings)) {
                return i;
            }
        }

        return -1;
    }

    // Helper method for prompting confirm dialog box.
    public int promptConfirm(String strMessage) {
        return JOptionPane.showConfirmDialog(null, strMessage, "Confirm Question", 
                                             JOptionPane.YES_NO_OPTION);
    }

    // Helper method for prompting input dialog box with error handling.
    public int promptInput(String strMessage) {
        // Loop will continue until the user enters a valid input or cancels the order.
        while (true) {
            try {
                String strInput = JOptionPane.showInputDialog(strMessage);
                if (strInput == null) cancelOrder();
                else return Integer.parseInt(strInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input.\nEnter integer values only!", 
                                              "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Helper method for cancelling the order.
    public void cancelOrder() {
        if (promptConfirm("Want to CANCEL order?") == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you!");
            System.exit(0);
        }
    }

}