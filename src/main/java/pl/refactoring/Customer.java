package pl.refactoring;

import java.util.LinkedHashSet;
import java.util.Set;

public class Customer {

    private String name;
    private Set<Rental> rentals = new LinkedHashSet<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            result += "\t" + each.getMovieTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "You owed " + String.valueOf(calculateTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(calculateFrequentRenterPoints()) + " frequent renter points\n";
        return result;
    }

    private int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

}
