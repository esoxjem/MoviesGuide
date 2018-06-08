package com.esoxjem.movieguide.network;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum RequestInterceptor_Factory implements Factory<RequestInterceptor> {
  INSTANCE;

  @Override
  public RequestInterceptor get() {
    return new RequestInterceptor();
  }

  public static Factory<RequestInterceptor> create() {
    return INSTANCE;
  }
}
