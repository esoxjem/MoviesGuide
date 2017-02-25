package com.esoxjem.movieguide.di.component;

import com.esoxjem.movieguide.di.module.ListingModule;
import com.esoxjem.movieguide.di.module.SortingModule;
import com.esoxjem.movieguide.di.scope.ListingScope;
import com.esoxjem.movieguide.view.fragment.MoviesListingFragment;
import com.esoxjem.movieguide.view.fragment.SortingDialogFragment;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent
{
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
