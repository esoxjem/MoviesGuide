package com.esoxjem.movieguide;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideResourcesFactory implements Factory<Resources> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideResourcesFactory(AppModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public Resources get() {
    return Preconditions.checkNotNull(
        module.provideResources(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Resources> create(AppModule module, Provider<Context> contextProvider) {
    return new AppModule_ProvideResourcesFactory(module, contextProvider);
  }
}
