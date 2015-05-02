package pl.refactoring;

public class NewReleaseMoviePrice extends MoviePrice {
    @Override
    int priceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double charge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int calculateFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (priceCode() == Movie.NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
