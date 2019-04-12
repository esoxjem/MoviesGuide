package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arun
 */
public interface MoviesListingPresenter
{
    void firstPage();

    void nextPage();

    void nextPage(int pageNumber, List<Movie> movies);

    void setView(MoviesListingView view);

    void searchMovie(String searchText);

    void searchMovieBackPressed();

    void destroy();
}
