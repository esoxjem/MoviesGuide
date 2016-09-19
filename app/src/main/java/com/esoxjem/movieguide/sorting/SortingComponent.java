package com.esoxjem.movieguide.sorting;

import com.esoxjem.movieguide.ActivityScope;

import dagger.Subcomponent;

/**
 * @author Ashwini Kumar.
 */
@ActivityScope
@Subcomponent(modules = SortingModule.class)
public interface SortingComponent
{
    void inject(SortingDialogFragment sortingDialogFragment);
}
