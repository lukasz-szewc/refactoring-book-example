package pl.refactoring;

public class RegularPriceMovie extends MoviePrice {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }

    @Override
    int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
