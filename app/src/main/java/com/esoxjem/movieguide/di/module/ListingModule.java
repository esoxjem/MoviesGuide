package com.esoxjem.movieguide.di.module;

import com.esoxjem.movieguide.data.modelpresenter.FavoritesInteractor;
import com.esoxjem.movieguide.data.modelpresenter.MoviesListingInteractor;
import com.esoxjem.movieguide.data.modelpresenter.MoviesListingInteractorImpl;
import com.esoxjem.movieguide.presenter.MoviesListingPresenter;
import com.esoxjem.movieguide.presenter.MoviesListingPresenterImpl;
import com.esoxjem.movieguide.data.remote.network.RequestHandler;
import com.esoxjem.movieguide.data.prefs.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule
{
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          RequestHandler requestHandler,
                                                          SortingOptionStore sortingOptionStore)
    {
        return new MoviesListingInteractorImpl(favoritesInteractor, requestHandler, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor)
    {
        return new MoviesListingPresenterImpl(interactor);
    }
}
