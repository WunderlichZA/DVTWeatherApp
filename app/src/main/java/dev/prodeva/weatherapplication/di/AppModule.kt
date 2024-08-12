package dev.prodeva.weatherapplication.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.prodeva.weatherapplication.data.remote.WeatherAPI
import dev.prodeva.weatherapplication.data.repositories.WeatherRepositoryImpl
import dev.prodeva.weatherapplication.domain.repositories.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesWeatherApi(): WeatherAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesWeatherRepository(weatherAPI: WeatherAPI): WeatherRepository {
        return WeatherRepositoryImpl(weatherAPI)
    }


    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(
        application : Application
    ) : FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(application)
    }
}