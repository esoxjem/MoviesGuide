package com.esoxjem.movieguide.listing.sorting;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SortingOptionStore_Factory implements Factory<SortingOptionStore> {
  private final Provider<Context> contextProvider;

  public SortingOptionStore_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public SortingOptionStore get() {
    return new SortingOptionStore(contextProvider.get());
  }

  public static Factory<SortingOptionStore> create(Provider<Context> contextProvider) {
    return new SortingOptionStore_Factory(contextProvider);
  }
}
