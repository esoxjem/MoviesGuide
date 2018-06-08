package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.network.TmdbWebService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailsModule_ProvideInteractorFactory
    implements Factory<MovieDetailsInteractor> {
  private final DetailsModule module;

  private final Provider<TmdbWebService> tmdbWebServiceProvider;

  public DetailsModule_ProvideInteractorFactory(
      DetailsModule module, Provider<TmdbWebService> tmdbWebServiceProvider) {
    assert module != null;
    this.module = module;
    assert tmdbWebServiceProvider != null;
    this.tmdbWebServiceProvider = tmdbWebServiceProvider;
  }

  @Override
  public MovieDetailsInteractor get() {
    return Preconditions.checkNotNull(
        module.provideInteractor(tmdbWebServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MovieDetailsInteractor> create(
      DetailsModule module, Provider<TmdbWebService> tmdbWebServiceProvider) {
    return new DetailsModule_ProvideInteractorFactory(module, tmdbWebServiceProvider);
  }
}
