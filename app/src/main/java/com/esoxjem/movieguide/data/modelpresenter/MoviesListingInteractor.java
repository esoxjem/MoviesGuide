package com.esoxjem.movieguide.data.modelpresenter;

import com.esoxjem.movieguide.data.model.Movie;

import java.util.List;

import rx.Observable;

/**
 * @author arun
 */
public interface MoviesListingInteractor
{
    Observable<List<Movie>> fetchMovies();
}
