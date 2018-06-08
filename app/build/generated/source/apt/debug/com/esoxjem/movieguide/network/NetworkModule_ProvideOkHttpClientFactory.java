package com.esoxjem.movieguide.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  private final Provider<RequestInterceptor> requestInterceptorProvider;

  public NetworkModule_ProvideOkHttpClientFactory(
      NetworkModule module, Provider<RequestInterceptor> requestInterceptorProvider) {
    assert module != null;
    this.module = module;
    assert requestInterceptorProvider != null;
    this.requestInterceptorProvider = requestInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClient(requestInterceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(
      NetworkModule module, Provider<RequestInterceptor> requestInterceptorProvider) {
    return new NetworkModule_ProvideOkHttpClientFactory(module, requestInterceptorProvider);
  }
}
