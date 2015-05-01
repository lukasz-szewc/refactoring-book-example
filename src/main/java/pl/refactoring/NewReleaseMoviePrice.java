package pl.refactoring;

public class NewReleaseMoviePrice extends MoviePrice {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
