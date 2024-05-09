package com.example.flightapp.di

import android.app.Application
import androidx.room.Room
import com.example.flightapp.flighttime.data.MeasurableSensor
import com.example.flightapp.flighttime.data.data_source.FlightDatabase
import com.example.flightapp.flighttime.data.repository.FlightRepositoryImpl
//import com.example.flightapp.flighttime.data.repository.SensorRepositoryImpl
import com.example.flightapp.flighttime.domain.repository.FlightRepository
//import com.example.flightapp.flighttime.domain.repository.SensorRepository
import com.example.flightapp.flighttime.presentation.senor.LightSensor
import com.example.flightapp.flighttime.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFlightDatabase(app: Application): FlightDatabase {
        return Room.databaseBuilder(
            app,
            FlightDatabase::class.java,
            FlightDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFlightRepository(db: FlightDatabase): FlightRepository {
        return FlightRepositoryImpl(db.flightDao)
    }

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): MeasurableSensor {
        return LightSensor(app)
    }
/*    @Provides
    @Singleton
    fun provideSensorRepository(sensorManager: SensorManager): SensorRepository {
        return SensorRepositoryImpl(sensorManager)
    }*/

    @Provides
    @Singleton
    fun provideFlightUseCases(repository: FlightRepository): FlightUseCases {
        return FlightUseCases(
            getFlights = GetFlights(repository),
            deleteFlight = DeleteFlight(repository),
            addFlight = AddFlight(repository),
            getFlight = GetFlight(repository)
        )
    }
}