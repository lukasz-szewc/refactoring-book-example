package pl.refactoring;

abstract class MoviePrice {
    abstract int priceCode();

    abstract double charge(int daysRented);

    abstract int calculateFrequentRenterPoints(int daysRented);
}
