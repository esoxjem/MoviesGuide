package com.esoxjem.movieguide.listing;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ListingModule_ProvideMovieListingPresenterFactory
    implements Factory<MoviesListingPresenter> {
  private final ListingModule module;

  private final Provider<MoviesListingInteractor> interactorProvider;

  public ListingModule_ProvideMovieListingPresenterFactory(
      ListingModule module, Provider<MoviesListingInteractor> interactorProvider) {
    assert module != null;
    this.module = module;
    assert interactorProvider != null;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public MoviesListingPresenter get() {
    return Preconditions.checkNotNull(
        module.provideMovieListingPresenter(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MoviesListingPresenter> create(
      ListingModule module, Provider<MoviesListingInteractor> interactorProvider) {
    return new ListingModule_ProvideMovieListingPresenterFactory(module, interactorProvider);
  }
}
