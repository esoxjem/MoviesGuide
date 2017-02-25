package com.esoxjem.movieguide.view.presenterview;

import com.esoxjem.movieguide.data.model.Movie;

import java.util.List;

/**
 * @author arun
 */
public interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie);
}
