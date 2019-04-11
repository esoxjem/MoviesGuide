package com.esoxjem.movieguide.listing;

import android.graphics.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arun
 */
public interface MoviesListingPresenter
{
    void firstPage();

    void nextPage();

    void nextPage(int pageNumber, List<com.esoxjem.movieguide.Movie> movies);

    void setView(MoviesListingView view);

    void searchMovie(String searchText);

    void searchMovieBackPressed();

    void destroy();
}
