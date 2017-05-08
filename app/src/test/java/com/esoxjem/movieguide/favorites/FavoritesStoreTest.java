package com.esoxjem.movieguide.favorites;

import android.content.Context;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.Review;
import com.esoxjem.movieguide.Video;
import com.esoxjem.movieguide.util.RxSchedulersOverrideRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;


/**
 * Created by FunRat on 4/17/2017.
 */
@RunWith(RobolectricTestRunner.class)
public class FavoritesStoreTest {

    @Mock
    Context context;
    @Mock
    Movie movie;
    @Mock
    List<Video> videos;
    @Mock
    List<Review> reviews;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    private FavoritesStore favoritesStore;
    private String id = "MOVIE ID";

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        favoritesStore = new FavoritesStore(context);
    }

    @Test
    public void getFavoriteTestEmpty(){
        try{
            List<Movie> list = favoritesStore.getFavorites();
            assertEquals("Get Favorite Test", true, list.isEmpty());

        }catch(IOException e){
            System.out.println("FAILED TEST");
        }
    }


    @Test
    public void setFavoriteTest(){
        try{
            List<Movie> list = new ArrayList<Movie>();
            movie.setId(id);
            list.add(movie);
            favoritesStore.setFavorite(movie);
            assertEquals("Set Favorite Test", list, favoritesStore.getFavorites() );
        }catch(IOException e){
            System.out.println("FAILED TEST");
        }
    }

    @Test
    public void getFavoriteTestNotEmpty(){
        try {
            List<Movie> list = new ArrayList<Movie>();
            movie.setId(id);
            list.add(movie);
            assertEquals("Get Favorite Test Not Empty", list, favoritesStore.getFavorites());
        }catch(IOException e){
            System.out.println("FAILED TEST");
        }
    }

    @Test
    public void isFavoriteTestTrue(){
        assertEquals("is Favorite Test True", true, favoritesStore.isFavorite(id));
    }


    @Test
    public void removeFavoriteTest(){
        try{
            favoritesStore.unfavorite("MOVIE ID");
            assertEquals("Unfavorite Test", null, favoritesStore.getFavorites() );
        }catch(IOException e){
            System.out.println("FAILED TEST");
        }
    }

    @Test
    public void isFavoriteTestFalse(){
        assertEquals("is Favorite Test False", false, favoritesStore.isFavorite("NOT A MOVIE"));
    }

    @Test
    public void favoritesSizeLimit(){
        int size = 26;

        try {
            for (int i = 0; i < size; i++) {
                favoritesStore.setFavorite(movie);
                movie.setId("movie" + i);
            }

            assertEquals("Favorites size Limit Test", size, favoritesStore.getFavorites().size());
        }catch(IOException e){
            System.out.println("FAILED TEST");
        }

    }
}
