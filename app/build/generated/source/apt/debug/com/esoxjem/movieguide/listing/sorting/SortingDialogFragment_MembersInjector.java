package com.esoxjem.movieguide.listing.sorting;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SortingDialogFragment_MembersInjector
    implements MembersInjector<SortingDialogFragment> {
  private final Provider<SortingDialogPresenter> sortingDialogPresenterProvider;

  public SortingDialogFragment_MembersInjector(
      Provider<SortingDialogPresenter> sortingDialogPresenterProvider) {
    assert sortingDialogPresenterProvider != null;
    this.sortingDialogPresenterProvider = sortingDialogPresenterProvider;
  }

  public static MembersInjector<SortingDialogFragment> create(
      Provider<SortingDialogPresenter> sortingDialogPresenterProvider) {
    return new SortingDialogFragment_MembersInjector(sortingDialogPresenterProvider);
  }

  @Override
  public void injectMembers(SortingDialogFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.sortingDialogPresenter = sortingDialogPresenterProvider.get();
  }

  public static void injectSortingDialogPresenter(
      SortingDialogFragment instance,
      Provider<SortingDialogPresenter> sortingDialogPresenterProvider) {
    instance.sortingDialogPresenter = sortingDialogPresenterProvider.get();
  }
}
