package com.mohammadian.backgroundlocationtracker.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mohammadian.backgroundlocationtracker.client.DefaultLocationClient
import com.mohammadian.backgroundlocationtracker.client.LocationClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class AppModule {


    @Provides
    @Singleton
    fun provideFusedLocationClient(@ApplicationContext appContext: Context) : FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(appContext)
    }

    @Provides
    @Singleton
     fun bindLocationClient(@ApplicationContext appContext: Context,client:FusedLocationProviderClient) : LocationClient{
         return  DefaultLocationClient(
            appContext,
            client
        )
     }
}