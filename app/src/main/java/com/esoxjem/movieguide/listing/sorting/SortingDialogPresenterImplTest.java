package com.esoxjem.movieguide.listing.sorting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Context;

public class SortingDialogPresenterImplTest {
    @Before
    public void setUp(){
        @Mock
        Context context;

        @Mock
        SortingOptionStore sos;

        sos = new SortingOptionStore(context);
    }
    @Test
    public void constructorNullInteractor() {
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(null);
        assertEquals(sdpi.getSortingDialogInteractor(), null);
    }

    @Test
    public void constructorNullStore(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(null));
        SortingDialogInteractorImpl x = new SortingDialogInteractorImpl(null);
        assertEquals(x, sdpi.getSortingDialogInteractor());
    }

    @Test
    public void destroyWorks(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(sos));
        sdpi.destroy();
        assertEquals(sdpi.getView(), null);
    }

    @Test
    public void setViewNull(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(sos));
        sdpi.setView(null);
        assertEquals(sdpi.getView(), null);
    }

    @Test
    public void setLastSavedOptionTest(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(sos));
        int selectedOption = sdpi.getSortingDialogInteractor().getSelectedSortingOption();
        if(selectedOption == SortType.MOST_POPULAR.getValue()){
            assertEquals(sdpi.a, true);
        }
        else if(selectedOption == SortType.HIGHEST_RATED.getValue()){
            assertEquals(sdpi.b, true);
        }
        else assertEquals(sdpi.c, true);
    }

    @Test
    public void onHRTest(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(sos));
        sdpi.onHighestRatedMoviesSelected();
        if(sdpi.getSortingDialogInteractor().getSelectedSortingOption() != SortType.HIGHEST_RATED.getValue()){
            fail();
        }
    }

    @Test
    public void onFTest(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(sos));
        sdpi.onFavoritesSelected();
        if(sdpi.getSortingDialogInteractor().getSelectedSortingOption() != SortType.FAVORITES.getValue()){
            fail();
        }
    }

    @Test
    public void onPopTest(){
        SortingDialogPresenterImpl sdpi = new SortingDialogPresenterImpl(new SortingDialogInteractorImpl(sos));
        sdpi.onPopularMoviesSelected();
        if(sdpi.getSortingDialogInteractor().getSelectedSortingOption() != SortType.MOST_POPULAR.getValue()){
            fail();
        }
    }
}
