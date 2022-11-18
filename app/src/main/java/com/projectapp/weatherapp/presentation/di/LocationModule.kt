package com.projectapp.weatherapp.presentation.di

import com.projectapp.weatherapp.data.location.DefaultLocationTracker
import com.projectapp.weatherapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocationModule {

    @Binds
    @AppScope
    fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker
}