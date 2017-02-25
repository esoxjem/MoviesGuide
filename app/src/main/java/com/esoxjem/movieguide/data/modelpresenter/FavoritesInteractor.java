package com.esoxjem.movieguide.data.modelpresenter;

import com.esoxjem.movieguide.data.model.Movie;

import java.util.List;

/**
 * @author arun
 */
public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
