package com.example.flightsearcher.flight.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightSearchDao {

    @Query("SELECT * from airport WHERE iata_code LIKE '%' || :query || '%' OR name LIKE '%' || :query || '%' ORDER BY passengers DESC")
    suspend fun getAirportsByQueryOrderedByPassengers(query: String): List<AirportEntity>

    @Query("SELECT * from airport")
    suspend fun getAllAirports(): List<AirportEntity>

    @Insert
    suspend fun addFavorite(favoriteFlight: FavoriteFlightEntity)

    @Delete
    suspend fun removeFavorite(favoriteFlight: FavoriteFlightEntity)

    @Query("Select * from favorite")
    fun getAllFavorites(): Flow<List<FavoriteFlightEntity>>

    @Query("SELECT * from favorite WHERE departure_code = :departureCode AND destination_code = :destinationCode LIMIT 1")
    suspend fun getFavoriteNullable(departureCode: String, destinationCode: String): FavoriteFlightEntity?

    @Query("SELECT * from favorite WHERE departure_code = :departureCode AND destination_code = :destinationCode LIMIT 1")
    suspend fun getFavorite(departureCode: String, destinationCode: String): FavoriteFlightEntity

    @Query("SELECT * from airport WHERE iata_code = :airportCode LIMIT 1")
    suspend fun getAirportFromCode(airportCode: String): AirportEntity
}