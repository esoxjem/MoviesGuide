package com.esoxjem.movieguide.favorites;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FavoritesStore_Factory implements Factory<FavoritesStore> {
  private final Provider<Context> contextProvider;

  public FavoritesStore_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public FavoritesStore get() {
    return new FavoritesStore(contextProvider.get());
  }

  public static Factory<FavoritesStore> create(Provider<Context> contextProvider) {
    return new FavoritesStore_Factory(contextProvider);
  }
}
