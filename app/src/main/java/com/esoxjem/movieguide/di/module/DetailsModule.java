package com.esoxjem.movieguide.di.module;

import com.esoxjem.movieguide.data.modelpresenter.MovieDetailsInteractor;
import com.esoxjem.movieguide.data.modelpresenter.MovieDetailsInteractorImpl;
import com.esoxjem.movieguide.di.scope.DetailsScope;
import com.esoxjem.movieguide.presenter.MovieDetailsPresenter;
import com.esoxjem.movieguide.presenter.MovieDetailsPresenterImpl;
import com.esoxjem.movieguide.data.modelpresenter.FavoritesInteractor;
import com.esoxjem.movieguide.data.remote.network.RequestHandler;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule
{
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(RequestHandler requestHandler)
    {
        return new MovieDetailsInteractorImpl(requestHandler);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor)
    {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
