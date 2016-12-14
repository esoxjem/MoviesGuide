package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.Review;
import com.esoxjem.movieguide.Video;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author arunsasidharan
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieDetailsPresenterTest
{
    @Mock
    private IMovieDetailsView view;
    @Mock
    private MovieDetailsInteractor movieDetailsInteractor;
    @Mock
    private FavoritesInteractor favoritesInteractor;
    @Mock
    Movie movie;
    @Mock
    List<Video> videos;
    @Mock
    List<Review> reviews;

    private MovieDetailsPresenter movieDetailsPresenter;

    @Before
    public void setUp() throws Exception
    {
        movieDetailsPresenter = new MovieDetailsPresenter(movieDetailsInteractor, favoritesInteractor);
        movieDetailsPresenter.setView(view);
    }

    @Test
    public void shouldShowDetails()
    {
        movieDetailsPresenter.showDetails(movie);
        verify(view).showDetails(movie);
    }

    @Test
    public void shouldShowTrailers()
    {
        movieDetailsPresenter.onGetTrailersSuccess(videos);
        verify(view).showTrailers(videos);
    }

    @Test
    public void shouldShowReviews()
    {
        movieDetailsPresenter.onGetReviewsSuccess(reviews);
        verify(view).showReviews(reviews);
    }

    @Test
    public void shouldUnfavoriteIfFavoriteTapped()
    {
        when(movie.getId()).thenReturn("12345");
        when(favoritesInteractor.isFavorite(movie.getId())).thenReturn(true);
        movieDetailsPresenter.onFavoriteClick(movie);
        verify(view).showUnFavorited();

    }

    @Test
    public void shouldFavoriteIfUnfavoriteTapped()
    {
        when(movie.getId()).thenReturn("12345");
        when(favoritesInteractor.isFavorite(movie.getId())).thenReturn(false);
        movieDetailsPresenter.onFavoriteClick(movie);
        verify(view).showFavorited();

    }

}