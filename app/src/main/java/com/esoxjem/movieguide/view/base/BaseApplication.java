package com.esoxjem.movieguide.view.base;

import android.app.Application;
import android.os.StrictMode;

import com.esoxjem.movieguide.di.component.DaggerAppComponent;
import com.esoxjem.movieguide.di.component.AppComponent;
import com.esoxjem.movieguide.di.module.AppModule;
import com.esoxjem.movieguide.di.component.DetailsComponent;
import com.esoxjem.movieguide.di.module.DetailsModule;
import com.esoxjem.movieguide.di.module.FavoritesModule;
import com.esoxjem.movieguide.di.component.ListingComponent;
import com.esoxjem.movieguide.di.module.ListingModule;
import com.esoxjem.movieguide.di.module.NetworkModule;

/**
 * @author arun
 */
public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
