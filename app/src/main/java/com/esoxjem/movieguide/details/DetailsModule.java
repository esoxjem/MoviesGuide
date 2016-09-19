package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.ActivityScope;
import com.esoxjem.movieguide.favorites.IFavoritesInteractor;
import com.esoxjem.movieguide.network.RequestHandler;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author Ashwini Kumar.
 */
@Module
public class DetailsModule
{
    private MovieDetailsFragment movieDetailsFragment;

    public DetailsModule(MovieDetailsFragment movieDetailsFragment)
    {
        this.movieDetailsFragment = movieDetailsFragment;
    }

    @Provides
    @ActivityScope
    MovieDetailsFragment provideMovieDetailsFragment()
    {
        return movieDetailsFragment;
    }

    @Provides
    @ActivityScope
    IMovieDetailsInteractor provideInteractor(RequestHandler requestHandler)
    {
        return new MovieDetailsInteractor(requestHandler);
    }

    @Provides
    @ActivityScope
    IMovieDetailsPresenter providePresenter(IMovieDetailsInteractor detailsInteractor,
                                            IFavoritesInteractor favoritesInteractor)
    {
        return new MovieDetailsPresenter(detailsInteractor, favoritesInteractor);
    }
}
