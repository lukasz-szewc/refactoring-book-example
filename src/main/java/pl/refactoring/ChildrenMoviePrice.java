package pl.refactoring;

public class ChildrenMoviePrice extends MoviePrice {

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
