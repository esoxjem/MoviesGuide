package com.esoxjem.movieguide.favorites;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author Ashwini Kumar.
 */
@Module
public class FavoritesModule
{
    @Provides
    @Singleton
    IFavoritesInteractor provideFavouritesInteractor(FavoritesStore store)
    {
        return new FavoritesInteractor(store);
    }

    @Provides
    @Singleton
    FavoritesStore provideFavoritesStore(Context context)
    {
        return new FavoritesStore(context);
    }
}
