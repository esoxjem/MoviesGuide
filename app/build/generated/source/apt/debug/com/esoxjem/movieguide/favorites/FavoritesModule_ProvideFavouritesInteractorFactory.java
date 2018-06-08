package com.esoxjem.movieguide.favorites;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FavoritesModule_ProvideFavouritesInteractorFactory
    implements Factory<FavoritesInteractor> {
  private final FavoritesModule module;

  private final Provider<FavoritesStore> storeProvider;

  public FavoritesModule_ProvideFavouritesInteractorFactory(
      FavoritesModule module, Provider<FavoritesStore> storeProvider) {
    assert module != null;
    this.module = module;
    assert storeProvider != null;
    this.storeProvider = storeProvider;
  }

  @Override
  public FavoritesInteractor get() {
    return Preconditions.checkNotNull(
        module.provideFavouritesInteractor(storeProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FavoritesInteractor> create(
      FavoritesModule module, Provider<FavoritesStore> storeProvider) {
    return new FavoritesModule_ProvideFavouritesInteractorFactory(module, storeProvider);
  }
}
