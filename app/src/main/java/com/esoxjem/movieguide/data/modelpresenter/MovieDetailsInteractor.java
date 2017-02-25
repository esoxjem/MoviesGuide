package com.esoxjem.movieguide.data.modelpresenter;

import com.esoxjem.movieguide.data.model.Review;
import com.esoxjem.movieguide.data.model.Video;

import java.util.List;

import rx.Observable;

/**
 * @author arun
 */
public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
