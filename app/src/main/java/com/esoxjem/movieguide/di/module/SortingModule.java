package com.esoxjem.movieguide.di.module;

import com.esoxjem.movieguide.data.modelpresenter.SortingDialogInteractor;
import com.esoxjem.movieguide.data.modelpresenter.SortingDialogInteractorImpl;
import com.esoxjem.movieguide.presenter.SortingDialogPresenter;
import com.esoxjem.movieguide.presenter.SortingDialogPresenterImpl;
import com.esoxjem.movieguide.data.prefs.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class SortingModule
{
    @Provides
    SortingDialogInteractor providesSortingDialogInteractor(SortingOptionStore store)
    {
        return new SortingDialogInteractorImpl(store);
    }

    @Provides
    SortingDialogPresenter providePresenter(SortingDialogInteractor interactor)
    {
        return new SortingDialogPresenterImpl(interactor);
    }
}
