package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailsModule_ProvidePresenterFactory implements Factory<MovieDetailsPresenter> {
  private final DetailsModule module;

  private final Provider<MovieDetailsInteractor> detailsInteractorProvider;

  private final Provider<FavoritesInteractor> favoritesInteractorProvider;

  public DetailsModule_ProvidePresenterFactory(
      DetailsModule module,
      Provider<MovieDetailsInteractor> detailsInteractorProvider,
      Provider<FavoritesInteractor> favoritesInteractorProvider) {
    assert module != null;
    this.module = module;
    assert detailsInteractorProvider != null;
    this.detailsInteractorProvider = detailsInteractorProvider;
    assert favoritesInteractorProvider != null;
    this.favoritesInteractorProvider = favoritesInteractorProvider;
  }

  @Override
  public MovieDetailsPresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(detailsInteractorProvider.get(), favoritesInteractorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MovieDetailsPresenter> create(
      DetailsModule module,
      Provider<MovieDetailsInteractor> detailsInteractorProvider,
      Provider<FavoritesInteractor> favoritesInteractorProvider) {
    return new DetailsModule_ProvidePresenterFactory(
        module, detailsInteractorProvider, favoritesInteractorProvider);
  }
}
