package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.TmdbWebService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ListingModule_ProvideMovieListingInteractorFactory
    implements Factory<MoviesListingInteractor> {
  private final ListingModule module;

  private final Provider<FavoritesInteractor> favoritesInteractorProvider;

  private final Provider<TmdbWebService> tmdbWebServiceProvider;

  private final Provider<SortingOptionStore> sortingOptionStoreProvider;

  public ListingModule_ProvideMovieListingInteractorFactory(
      ListingModule module,
      Provider<FavoritesInteractor> favoritesInteractorProvider,
      Provider<TmdbWebService> tmdbWebServiceProvider,
      Provider<SortingOptionStore> sortingOptionStoreProvider) {
    assert module != null;
    this.module = module;
    assert favoritesInteractorProvider != null;
    this.favoritesInteractorProvider = favoritesInteractorProvider;
    assert tmdbWebServiceProvider != null;
    this.tmdbWebServiceProvider = tmdbWebServiceProvider;
    assert sortingOptionStoreProvider != null;
    this.sortingOptionStoreProvider = sortingOptionStoreProvider;
  }

  @Override
  public MoviesListingInteractor get() {
    return Preconditions.checkNotNull(
        module.provideMovieListingInteractor(
            favoritesInteractorProvider.get(),
            tmdbWebServiceProvider.get(),
            sortingOptionStoreProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MoviesListingInteractor> create(
      ListingModule module,
      Provider<FavoritesInteractor> favoritesInteractorProvider,
      Provider<TmdbWebService> tmdbWebServiceProvider,
      Provider<SortingOptionStore> sortingOptionStoreProvider) {
    return new ListingModule_ProvideMovieListingInteractorFactory(
        module, favoritesInteractorProvider, tmdbWebServiceProvider, sortingOptionStoreProvider);
  }
}
