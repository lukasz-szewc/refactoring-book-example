package pl.refactoring;

public class ChildrenMoviePrice extends MoviePrice {

    @Override
    int priceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double charge(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    @Override
    int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
