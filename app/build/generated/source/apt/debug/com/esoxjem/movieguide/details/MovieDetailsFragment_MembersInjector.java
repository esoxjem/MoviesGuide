package com.esoxjem.movieguide.details;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MovieDetailsFragment_MembersInjector
    implements MembersInjector<MovieDetailsFragment> {
  private final Provider<MovieDetailsPresenter> movieDetailsPresenterProvider;

  public MovieDetailsFragment_MembersInjector(
      Provider<MovieDetailsPresenter> movieDetailsPresenterProvider) {
    assert movieDetailsPresenterProvider != null;
    this.movieDetailsPresenterProvider = movieDetailsPresenterProvider;
  }

  public static MembersInjector<MovieDetailsFragment> create(
      Provider<MovieDetailsPresenter> movieDetailsPresenterProvider) {
    return new MovieDetailsFragment_MembersInjector(movieDetailsPresenterProvider);
  }

  @Override
  public void injectMembers(MovieDetailsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.movieDetailsPresenter = movieDetailsPresenterProvider.get();
  }

  public static void injectMovieDetailsPresenter(
      MovieDetailsFragment instance,
      Provider<MovieDetailsPresenter> movieDetailsPresenterProvider) {
    instance.movieDetailsPresenter = movieDetailsPresenterProvider.get();
  }
}
