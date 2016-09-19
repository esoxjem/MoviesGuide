package com.esoxjem.movieguide.sorting;

import android.content.Context;

import com.esoxjem.movieguide.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author Ashwini Kumar.
 */
@Module
public class SortingModule
{
    private SortingDialogFragment sortingDialogFragment;

    public SortingModule(SortingDialogFragment sortingDialogFragment)
    {
        this.sortingDialogFragment = sortingDialogFragment;
    }

    @Provides
    @ActivityScope
    SortingDialogFragment provideSortingDialogFragment()
    {
        return sortingDialogFragment;
    }

    @Provides
    @ActivityScope
    ISortingDialogInteractor providesSortingDialogInteractor(SortingOptionStore store)
    {
        return new SortingDialogInteractor(store);
    }

    @Provides
    @ActivityScope
    SortingOptionStore providesSortingOptionStore(Context context)
    {
        return new SortingOptionStore(context);
    }

    @Provides
    @ActivityScope
    ISortingDialogPresenter providePresenter(ISortingDialogInteractor interactor)
    {
        return new SortingDialogPresenter(interactor);
    }
}
