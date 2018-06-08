package com.esoxjem.movieguide;

import android.content.Context;
import com.esoxjem.movieguide.details.DetailsComponent;
import com.esoxjem.movieguide.details.DetailsModule;
import com.esoxjem.movieguide.details.DetailsModule_ProvideInteractorFactory;
import com.esoxjem.movieguide.details.DetailsModule_ProvidePresenterFactory;
import com.esoxjem.movieguide.details.MovieDetailsFragment;
import com.esoxjem.movieguide.details.MovieDetailsFragment_MembersInjector;
import com.esoxjem.movieguide.details.MovieDetailsInteractor;
import com.esoxjem.movieguide.details.MovieDetailsPresenter;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.favorites.FavoritesModule;
import com.esoxjem.movieguide.favorites.FavoritesModule_ProvideFavouritesInteractorFactory;
import com.esoxjem.movieguide.favorites.FavoritesStore;
import com.esoxjem.movieguide.favorites.FavoritesStore_Factory;
import com.esoxjem.movieguide.listing.ListingComponent;
import com.esoxjem.movieguide.listing.ListingModule;
import com.esoxjem.movieguide.listing.ListingModule_ProvideMovieListingInteractorFactory;
import com.esoxjem.movieguide.listing.ListingModule_ProvideMovieListingPresenterFactory;
import com.esoxjem.movieguide.listing.MoviesListingFragment;
import com.esoxjem.movieguide.listing.MoviesListingFragment_MembersInjector;
import com.esoxjem.movieguide.listing.MoviesListingInteractor;
import com.esoxjem.movieguide.listing.MoviesListingPresenter;
import com.esoxjem.movieguide.listing.sorting.SortingDialogFragment;
import com.esoxjem.movieguide.listing.sorting.SortingDialogFragment_MembersInjector;
import com.esoxjem.movieguide.listing.sorting.SortingDialogInteractor;
import com.esoxjem.movieguide.listing.sorting.SortingDialogPresenter;
import com.esoxjem.movieguide.listing.sorting.SortingModule;
import com.esoxjem.movieguide.listing.sorting.SortingModule_ProvidePresenterFactory;
import com.esoxjem.movieguide.listing.sorting.SortingModule_ProvidesSortingDialogInteractorFactory;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore_Factory;
import com.esoxjem.movieguide.network.NetworkModule;
import com.esoxjem.movieguide.network.NetworkModule_ProvideOkHttpClientFactory;
import com.esoxjem.movieguide.network.NetworkModule_RetrofitFactory;
import com.esoxjem.movieguide.network.NetworkModule_TmdbWebServiceFactory;
import com.esoxjem.movieguide.network.RequestInterceptor;
import com.esoxjem.movieguide.network.RequestInterceptor_Factory;
import com.esoxjem.movieguide.network.TmdbWebService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<RequestInterceptor> requestInterceptorProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<TmdbWebService> tmdbWebServiceProvider;

  private Provider<Context> provideContextProvider;

  private Provider<FavoritesStore> favoritesStoreProvider;

  private Provider<FavoritesInteractor> provideFavouritesInteractorProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.requestInterceptorProvider = DoubleCheck.provider(RequestInterceptor_Factory.create());

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            NetworkModule_ProvideOkHttpClientFactory.create(
                builder.networkModule, requestInterceptorProvider));

    this.retrofitProvider =
        DoubleCheck.provider(
            NetworkModule_RetrofitFactory.create(
                builder.networkModule, provideOkHttpClientProvider));

    this.tmdbWebServiceProvider =
        DoubleCheck.provider(
            NetworkModule_TmdbWebServiceFactory.create(builder.networkModule, retrofitProvider));

    this.provideContextProvider =
        DoubleCheck.provider(AppModule_ProvideContextFactory.create(builder.appModule));

    this.favoritesStoreProvider =
        DoubleCheck.provider(FavoritesStore_Factory.create(provideContextProvider));

    this.provideFavouritesInteractorProvider =
        DoubleCheck.provider(
            FavoritesModule_ProvideFavouritesInteractorFactory.create(
                builder.favoritesModule, favoritesStoreProvider));
  }

  @Override
  public DetailsComponent plus(DetailsModule detailsModule) {
    return new DetailsComponentImpl(detailsModule);
  }

  @Override
  public ListingComponent plus(ListingModule listingModule) {
    return new ListingComponentImpl(listingModule);
  }

  public static final class Builder {
    private NetworkModule networkModule;

    private AppModule appModule;

    private FavoritesModule favoritesModule;

    private Builder() {}

    public AppComponent build() {
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (favoritesModule == null) {
        this.favoritesModule = new FavoritesModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder favoritesModule(FavoritesModule favoritesModule) {
      this.favoritesModule = Preconditions.checkNotNull(favoritesModule);
      return this;
    }
  }

  private final class DetailsComponentImpl implements DetailsComponent {
    private final DetailsModule detailsModule;

    private Provider<MovieDetailsInteractor> provideInteractorProvider;

    private Provider<MovieDetailsPresenter> providePresenterProvider;

    private MembersInjector<MovieDetailsFragment> movieDetailsFragmentMembersInjector;

    private DetailsComponentImpl(DetailsModule detailsModule) {
      this.detailsModule = Preconditions.checkNotNull(detailsModule);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.provideInteractorProvider =
          DoubleCheck.provider(
              DetailsModule_ProvideInteractorFactory.create(
                  detailsModule, DaggerAppComponent.this.tmdbWebServiceProvider));

      this.providePresenterProvider =
          DoubleCheck.provider(
              DetailsModule_ProvidePresenterFactory.create(
                  detailsModule,
                  provideInteractorProvider,
                  DaggerAppComponent.this.provideFavouritesInteractorProvider));

      this.movieDetailsFragmentMembersInjector =
          MovieDetailsFragment_MembersInjector.create(providePresenterProvider);
    }

    @Override
    public void inject(MovieDetailsFragment target) {
      movieDetailsFragmentMembersInjector.injectMembers(target);
    }
  }

  private final class ListingComponentImpl implements ListingComponent {
    private final ListingModule listingModule;

    private final SortingModule sortingModule;

    private Provider<SortingOptionStore> sortingOptionStoreProvider;

    private Provider<MoviesListingInteractor> provideMovieListingInteractorProvider;

    private Provider<MoviesListingPresenter> provideMovieListingPresenterProvider;

    private MembersInjector<MoviesListingFragment> moviesListingFragmentMembersInjector;

    private Provider<SortingDialogInteractor> providesSortingDialogInteractorProvider;

    private Provider<SortingDialogPresenter> providePresenterProvider;

    private MembersInjector<SortingDialogFragment> sortingDialogFragmentMembersInjector;

    private ListingComponentImpl(ListingModule listingModule) {
      this.listingModule = Preconditions.checkNotNull(listingModule);
      this.sortingModule = new SortingModule();
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.sortingOptionStoreProvider =
          SortingOptionStore_Factory.create(DaggerAppComponent.this.provideContextProvider);

      this.provideMovieListingInteractorProvider =
          ListingModule_ProvideMovieListingInteractorFactory.create(
              listingModule,
              DaggerAppComponent.this.provideFavouritesInteractorProvider,
              DaggerAppComponent.this.tmdbWebServiceProvider,
              sortingOptionStoreProvider);

      this.provideMovieListingPresenterProvider =
          ListingModule_ProvideMovieListingPresenterFactory.create(
              listingModule, provideMovieListingInteractorProvider);

      this.moviesListingFragmentMembersInjector =
          MoviesListingFragment_MembersInjector.create(provideMovieListingPresenterProvider);

      this.providesSortingDialogInteractorProvider =
          SortingModule_ProvidesSortingDialogInteractorFactory.create(
              sortingModule, sortingOptionStoreProvider);

      this.providePresenterProvider =
          SortingModule_ProvidePresenterFactory.create(
              sortingModule, providesSortingDialogInteractorProvider);

      this.sortingDialogFragmentMembersInjector =
          SortingDialogFragment_MembersInjector.create(providePresenterProvider);
    }

    @Override
    public MoviesListingFragment inject(MoviesListingFragment fragment) {
      moviesListingFragmentMembersInjector.injectMembers(fragment);
      return fragment;
    }

    @Override
    public SortingDialogFragment inject(SortingDialogFragment fragment) {
      sortingDialogFragmentMembersInjector.injectMembers(fragment);
      return fragment;
    }
  }
}
