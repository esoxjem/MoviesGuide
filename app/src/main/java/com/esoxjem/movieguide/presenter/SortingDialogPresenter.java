package com.esoxjem.movieguide.presenter;

import com.esoxjem.movieguide.view.presenterview.SortingDialogView;

/**
 * @author arun
 */
public interface SortingDialogPresenter
{
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
