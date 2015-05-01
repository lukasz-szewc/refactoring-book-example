package pl.refactoring;

public class NewReleaseMoviePrice extends MoviePrice {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int calculateFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
