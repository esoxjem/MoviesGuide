package com.esoxjem.movieguide.listing;

import android.content.Context;

import com.esoxjem.movieguide.ActivityScope;
import com.esoxjem.movieguide.favorites.IFavoritesInteractor;
import com.esoxjem.movieguide.network.RequestHandler;
import com.esoxjem.movieguide.sorting.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author Ashwini Kumar.
 */
@Module
public class ListingModule
{
    private MoviesListingFragment moviesListingFragment;

    public ListingModule(MoviesListingFragment moviesListingFragment)
    {
        this.moviesListingFragment = moviesListingFragment;
    }

    @Provides
    @ActivityScope
    MoviesListingFragment provideMoviesListingFragment()
    {
        return moviesListingFragment;
    }

    @Provides
    @ActivityScope
    IMoviesListingInteractor provideMovieListingInteractor(IFavoritesInteractor favoritesInteractor,
                                                           RequestHandler requestHandler,
                                                           SortingOptionStore sortingOptionStore)
    {
        return new MoviesListingInteractor(favoritesInteractor, requestHandler, sortingOptionStore);
    }

    @Provides
    @ActivityScope
    IMoviesListingPresenter provideMovieListingPresenter(IMoviesListingInteractor interactor)
    {
        return new MoviesListingPresenter(interactor);
    }

    @Provides
    @ActivityScope
    SortingOptionStore providesSortingOptionStore(Context context)
    {
        return new SortingOptionStore(context);
    }
}
