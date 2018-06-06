package com.esoxjem.movieguide.listing.sorting;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SortingModule_ProvidePresenterFactory
    implements Factory<SortingDialogPresenter> {
  private final SortingModule module;

  private final Provider<SortingDialogInteractor> interactorProvider;

  public SortingModule_ProvidePresenterFactory(
      SortingModule module, Provider<SortingDialogInteractor> interactorProvider) {
    assert module != null;
    this.module = module;
    assert interactorProvider != null;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public SortingDialogPresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SortingDialogPresenter> create(
      SortingModule module, Provider<SortingDialogInteractor> interactorProvider) {
    return new SortingModule_ProvidePresenterFactory(module, interactorProvider);
  }
}
