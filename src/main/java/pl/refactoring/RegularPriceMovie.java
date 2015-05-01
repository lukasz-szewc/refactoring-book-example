package pl.refactoring;

public class RegularPriceMovie extends MoviePrice {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
