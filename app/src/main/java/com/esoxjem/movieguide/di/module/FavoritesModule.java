package com.esoxjem.movieguide.di.module;

import com.esoxjem.movieguide.data.modelpresenter.FavoritesInteractor;
import com.esoxjem.movieguide.data.modelpresenter.FavoritesInteractorImpl;
import com.esoxjem.movieguide.data.prefs.FavoritesStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 */
@Module(includes = AppModule.class)
public class FavoritesModule
{
    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store)
    {
        return new FavoritesInteractorImpl(store);
    }
}
