package com.esoxjem.movieguide.listing;

import android.view.View;

import com.esoxjem.movieguide.Movie;

import java.util.List;

/**
 * @author arun
 */
interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie,View view);
}
