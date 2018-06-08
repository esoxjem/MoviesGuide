package com.esoxjem.movieguide.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_RequestInterceptorFactory implements Factory<Interceptor> {
  private final NetworkModule module;

  private final Provider<RequestInterceptor> interceptorProvider;

  public NetworkModule_RequestInterceptorFactory(
      NetworkModule module, Provider<RequestInterceptor> interceptorProvider) {
    assert module != null;
    this.module = module;
    assert interceptorProvider != null;
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.requestInterceptor(interceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interceptor> create(
      NetworkModule module, Provider<RequestInterceptor> interceptorProvider) {
    return new NetworkModule_RequestInterceptorFactory(module, interceptorProvider);
  }
}
