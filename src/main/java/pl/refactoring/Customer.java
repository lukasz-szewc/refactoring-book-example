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

    public String statement() {
        String result = "Rental Record for " + name + "\n";
        result += statementForEachRental();
        result += "You owed " + calculateTotalAmount() + "\n";
        result += "You earned " + calculateFrequentRenterPoints() + " frequent renter points\n";
        return result;
    }

    private String statementForEachRental() {
        String result = "";
        for (Rental each : rentals) {
            result += "\t" + each.movieTitle() + "\t" + String.valueOf(each.calculateCharge()) + "\n";
        }
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
            totalAmount += rental.calculateCharge();
        }
        return totalAmount;
    }

}
