package pl.refactoring;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    int calculateFrequentRenterPoints() {
        return movie.calculateFrequentRenterPoints(daysRented);
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }
}
