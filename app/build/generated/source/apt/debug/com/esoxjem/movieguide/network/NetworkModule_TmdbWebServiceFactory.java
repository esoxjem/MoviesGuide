package com.esoxjem.movieguide.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_TmdbWebServiceFactory implements Factory<TmdbWebService> {
  private final NetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_TmdbWebServiceFactory(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public TmdbWebService get() {
    return Preconditions.checkNotNull(
        module.tmdbWebService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TmdbWebService> create(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_TmdbWebServiceFactory(module, retrofitProvider);
  }
}
