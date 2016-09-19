package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.ActivityScope;

import dagger.Subcomponent;

/**
 * @author Ashwini Kumar.
 */
@ActivityScope
@Subcomponent(modules = DetailsModule.class)
public interface DetailsComponent
{
    void inject(MovieDetailsFragment movieDetailsFragment);
}
