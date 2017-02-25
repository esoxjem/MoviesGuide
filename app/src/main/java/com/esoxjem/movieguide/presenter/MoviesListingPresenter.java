package com.esoxjem.movieguide.presenter;

import com.esoxjem.movieguide.view.presenterview.MoviesListingView;

/**
 * @author arun
 */
public interface MoviesListingPresenter
{
    void displayMovies();

    void setView(MoviesListingView view);

    void destroy();
}
