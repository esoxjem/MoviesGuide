package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Movie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * @author arunsasidharan
 */
@RunWith(MockitoJUnitRunner.class)
public class MoviesListingPresenterTest
{
    @Mock
    private IMoviesListingInteractor interactor;
    @Mock
    private IMoviesListingView view;
    @Mock
    Throwable throwable;
    @Mock
    private List<Movie> movies;

    private MoviesListingPresenter presenter;

    @Before
    public void setUp() throws Exception
    {
        presenter = new MoviesListingPresenter(interactor);
        presenter.setView(view);
    }

    @Test
    public void shouldShowFetchError()
    {
        presenter.onMovieFetchFailed(throwable);
        verify(view).loadingFailed(throwable.getMessage());
    }

    @Test
    public void shouldShowMoviesWhenSuccessfullyFetched()
    {
        presenter.onMovieFetchSuccess(movies);
        verify(view).showMovies(movies);
    }

}