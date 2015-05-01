package pl.refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MoviePrice price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int code) {
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

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int calculateFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (getPriceCode() == NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
