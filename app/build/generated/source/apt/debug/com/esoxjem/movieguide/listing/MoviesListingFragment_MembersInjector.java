package com.esoxjem.movieguide.listing;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MoviesListingFragment_MembersInjector
    implements MembersInjector<MoviesListingFragment> {
  private final Provider<MoviesListingPresenter> moviesPresenterProvider;

  public MoviesListingFragment_MembersInjector(
      Provider<MoviesListingPresenter> moviesPresenterProvider) {
    assert moviesPresenterProvider != null;
    this.moviesPresenterProvider = moviesPresenterProvider;
  }

  public static MembersInjector<MoviesListingFragment> create(
      Provider<MoviesListingPresenter> moviesPresenterProvider) {
    return new MoviesListingFragment_MembersInjector(moviesPresenterProvider);
  }

  @Override
  public void injectMembers(MoviesListingFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.moviesPresenter = moviesPresenterProvider.get();
  }

  public static void injectMoviesPresenter(
      MoviesListingFragment instance, Provider<MoviesListingPresenter> moviesPresenterProvider) {
    instance.moviesPresenter = moviesPresenterProvider.get();
  }
}
