package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.ActivityScope;

import dagger.Subcomponent;

/**
 * @author Ashwini Kumar.
 */
@ActivityScope
@Subcomponent(modules = ListingModule.class)
public interface ListingComponent
{
    void inject(MoviesListingFragment moviesListingFragment);
}
