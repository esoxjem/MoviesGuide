package com.esoxjem.movieguide.di.component;

import com.esoxjem.movieguide.di.module.AppModule;
import com.esoxjem.movieguide.di.module.DetailsModule;
import com.esoxjem.movieguide.di.module.FavoritesModule;
import com.esoxjem.movieguide.di.module.ListingModule;
import com.esoxjem.movieguide.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
