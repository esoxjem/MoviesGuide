package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.RequestHandler;
import com.esoxjem.movieguide.util.RxSchedulersOverrideRule;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import java.util.List;
import rx.Observable;

@RunWith(RobolectricTestRunner.class)
public class MoviesListingInteractorImplTest {
    @Mock
    private FavoritesInteractor favoritesInteractor;
    @Mock
    private RequestHandler requestHandler;
    @Mock
    private SortingOptionStore sortingOptionStore;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    private MoviesListingInteractorImpl interactor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        interactor = new MoviesListingInteractorImpl(favoritesInteractor, requestHandler, sortingOptionStore);
    }

    @Test
    public void emptyFavoritesTest() {
        Observable<List<Movie>> list = interactor.fetchMovies();
        Observable<List<Movie>> emptyList = Observable.empty();
        assertEquals(emptyList, list);
        //empty the favorites list
        //call fetchMovies() and test that the list is empty
    }

    @Test
    public void favoritesTest() {
        When()
        //create several movies and insert them into the favorites list
        //call fetchMovies() and test that all the movies are in the returned list
    }

    @Test
    public void popularTest() {
        //connect to library and obtain list of most popular movies
        //call fetchMovies() and test that the most popular movies are in the returned list
    }

    @Test
    public void highestRatedTest() {
        //connect to library and obtain list of highest rated movies
        //call fetchMovies() and test that the highest rated movies are in the returned list
    }
}


