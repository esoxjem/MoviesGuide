package com.esoxjem.movieguide.listing.sorting;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SortingModule_ProvidesSortingDialogInteractorFactory
    implements Factory<SortingDialogInteractor> {
  private final SortingModule module;

  private final Provider<SortingOptionStore> storeProvider;

  public SortingModule_ProvidesSortingDialogInteractorFactory(
      SortingModule module, Provider<SortingOptionStore> storeProvider) {
    assert module != null;
    this.module = module;
    assert storeProvider != null;
    this.storeProvider = storeProvider;
  }

  @Override
  public SortingDialogInteractor get() {
    return Preconditions.checkNotNull(
        module.providesSortingDialogInteractor(storeProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SortingDialogInteractor> create(
      SortingModule module, Provider<SortingOptionStore> storeProvider) {
    return new SortingModule_ProvidesSortingDialogInteractorFactory(module, storeProvider);
  }
}
