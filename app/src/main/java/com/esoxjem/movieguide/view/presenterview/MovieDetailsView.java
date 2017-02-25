package com.esoxjem.movieguide.view.presenterview;

import com.esoxjem.movieguide.data.model.Movie;
import com.esoxjem.movieguide.data.model.Review;
import com.esoxjem.movieguide.data.model.Video;

import java.util.List;

/**
 * @author arun
 */
public interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
