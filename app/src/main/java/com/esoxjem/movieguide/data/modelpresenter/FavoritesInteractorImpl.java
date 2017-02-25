package com.esoxjem.movieguide.data.modelpresenter;

import com.esoxjem.movieguide.data.model.Movie;
import com.esoxjem.movieguide.data.prefs.FavoritesStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arun
 */
public class FavoritesInteractorImpl implements FavoritesInteractor
{
    private FavoritesStore favoritesStore;

    public FavoritesInteractorImpl(FavoritesStore store)
    {
        favoritesStore = store;
    }

    @Override
    public void setFavorite(Movie movie)
    {
        favoritesStore.setFavorite(movie);
    }

    @Override
    public boolean isFavorite(String id)
    {
        return favoritesStore.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites()
    {
        try
        {
            return favoritesStore.getFavorites();
        } catch (IOException ignored)
        {
            return new ArrayList<>(0);
        }
    }

    @Override
    public void unFavorite(String id)
    {
        favoritesStore.unfavorite(id);
    }
}
