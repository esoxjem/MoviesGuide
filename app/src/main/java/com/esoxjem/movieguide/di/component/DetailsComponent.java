package com.esoxjem.movieguide.di.component;

import com.esoxjem.movieguide.view.fragment.MovieDetailsFragment;
import com.esoxjem.movieguide.di.module.DetailsModule;
import com.esoxjem.movieguide.di.scope.DetailsScope;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent
{
    void inject(MovieDetailsFragment target);
}
