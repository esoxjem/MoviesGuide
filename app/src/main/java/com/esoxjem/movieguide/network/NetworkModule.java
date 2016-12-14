package com.esoxjem.movieguide.network;


import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author pulkitkumar
 */
@Module
public class NetworkModule
{
    public static final int CONNECT_TIMEOUT_IN_MS = 30000;

    @Provides
    @Singleton
    CookieManager provideCookieManager()
    {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        return cookieManager;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(CookieManager cookieManager)
    {
        return new okhttp3.OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @Singleton
    RequestHandler provideRequestHandler(OkHttpClient okHttpClient)
    {
        return new RequestHandler(okHttpClient);
    }
}
