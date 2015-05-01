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
        double thisAmount = 0;
        switch (getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    int calculateFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (getPriceCode() == NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
