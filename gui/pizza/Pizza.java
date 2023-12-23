package pizza;

public class Pizza {
    
    // Attributes for the pizza.
    private String strToppings, strDiscount;
    private int intDiameter, intHowMany;
    private double dblPrice;

    // Lines 11-34 are the getters and setters for the attributes.
    public void setToppings(String strToppings) {
        this.strToppings = strToppings;
    }
    
    public String getToppings() {
        return strToppings;
    }
    
    public void setDiscount(String strDiscount) {
        this.strDiscount = strDiscount;
    }

    public void setDiameter(int intDiameter) {
        this.intDiameter = intDiameter;
    }
    
    public int getDiameter() {
        intDiameter = intDiameter * 5 / 2;
        return intDiameter;
    }
    
    public void setHowMany(int intHowMany) {
        this.intHowMany = intHowMany;
    }

    // Getter for the price of the pizza with calculations.
    public double getPrice() {
        double dblToppingsPrice = 0.0;

        // Evalueates the price of the pizza depending on the chosen toppings.
        if (strToppings.equals("Pepperoni")) dblToppingsPrice = 100.00;
        else if (strToppings.equals("Ham and Cheese")) dblToppingsPrice = 150.00;
        else if (strToppings.equals("Hawaiian")) dblToppingsPrice = 200.00;

        dblPrice = intDiameter * 5.00;
        dblPrice += dblToppingsPrice;

        // Evaluates the price of the pizza depending on the chosen discount.
        if (strDiscount.equals("Senior-PWD")) dblPrice -= dblPrice * 0.20;
        else if (strDiscount.equalsIgnoreCase("VIP")) dblPrice -= dblPrice * 0.12;

        return dblPrice * intHowMany;
    }

}