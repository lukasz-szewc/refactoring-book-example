package pl.refactoring;

public class RegularPriceMovie extends MoviePrice {
    @Override
    int priceCode() {
        return Movie.REGULAR;
    }

    @Override
    double charge(int daysRented) {
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
