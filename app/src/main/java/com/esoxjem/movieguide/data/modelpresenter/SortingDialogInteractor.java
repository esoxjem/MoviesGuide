package com.esoxjem.movieguide.data.modelpresenter;

import com.esoxjem.movieguide.data.model.SortType;

/**
 * @author arun
 */
public interface SortingDialogInteractor
{
    int getSelectedSortingOption();

    void setSortingOption(SortType sortType);
}
