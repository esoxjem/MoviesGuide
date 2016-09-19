package com.esoxjem.movieguide.sorting;

import javax.inject.Inject;

/**
 * @author arun
 */
public class SortingDialogInteractor implements ISortingDialogInteractor
{
    private SortingOptionStore sortingOptionStore;

    @Inject
    public SortingDialogInteractor(SortingOptionStore store)
    {
        sortingOptionStore = store;
    }

    @Override
    public int getSelectedSortingOption()
    {
        return sortingOptionStore.getSelectedOption();
    }

    @Override
    public void setSortingOption(SortType sortType)
    {
        sortingOptionStore.setSelectedOption(sortType);
    }
}
