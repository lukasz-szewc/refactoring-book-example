package pl.refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }

        result += "You owed " + String.valueOf(calculateTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(calculateFrequentRenterPoints()) + " frequent renter points\n";

        return result;
    }

    private double calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Object rental : rentals) {
            Rental each = (Rental) rental;
            frequentRenterPoints += each.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            totalAmount += castRental(elements).getCharge();
        }
        return totalAmount;
    }

    private Rental castRental(Enumeration elements) {
        return ((Rental) elements.nextElement());
    }

}
