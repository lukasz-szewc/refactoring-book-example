package pl.refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MoviePrice price;

    public Movie(String title, int priceCode) {
        this.title = title;
        initializePrice(priceCode);
    }

    private void initializePrice(int code) {
        if (REGULAR == code) {
            price = new RegularPriceMovie();
        } else if (CHILDRENS == code) {
            price = new ChildrenMoviePrice();
        } else if (NEW_RELEASE == code) {
            price = new NewReleaseMoviePrice();
        } else {
            throw new IllegalStateException();
        }
    }

    String title() {
        return title;
    }

    double calculateCharge(int daysRented) {
        return price.charge(daysRented);
    }

    int calculateFrequentRenterPoints(int daysRented) {
        return price.calculateFrequentRenterPoints(daysRented);
    }
}
