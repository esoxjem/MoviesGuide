package com.esoxjem.movieguide.presenter;

import com.esoxjem.movieguide.data.modelpresenter.MoviesListingInteractor;
import com.esoxjem.movieguide.view.presenterview.MoviesListingView;
import com.esoxjem.movieguide.data.model.Movie;
import com.esoxjem.movieguide.util.RxUtils;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arun
 */
public class MoviesListingPresenterImpl implements MoviesListingPresenter
{
    private MoviesListingView view;
    private MoviesListingInteractor moviesInteractor;
    private Subscription fetchSubscription;

    public MoviesListingPresenterImpl(MoviesListingInteractor interactor)
    {
        moviesInteractor = interactor;
    }

    @Override
    public void setView(MoviesListingView view)
    {
        this.view = view;
        displayMovies();
    }

    @Override
    public void destroy()
    {
        view = null;
        RxUtils.unsubscribe(fetchSubscription);
    }

    @Override
    public void displayMovies()
    {
        showLoading();
        fetchSubscription = moviesInteractor.fetchMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onMovieFetchSuccess, this::onMovieFetchFailed);
    }

    private void showLoading()
    {
        if (isViewAttached())
        {
            view.loadingStarted();
        }
    }

    private void onMovieFetchSuccess(List<Movie> movies)
    {
        if (isViewAttached())
        {
            view.showMovies(movies);
        }
    }

    private void onMovieFetchFailed(Throwable e)
    {
        view.loadingFailed(e.getMessage());
    }

    private boolean isViewAttached()
    {
        return view != null;
    }
}
