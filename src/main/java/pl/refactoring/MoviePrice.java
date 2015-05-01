package pl.refactoring;

abstract class MoviePrice {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}
