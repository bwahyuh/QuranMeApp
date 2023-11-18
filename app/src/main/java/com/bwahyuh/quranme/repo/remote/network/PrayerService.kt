package com.bwahyuh.quranme.repo.remote.network

import com.bwahyuh.quranme.repo.remote.response.PrayerScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerService {
    @GET("calendar")
    suspend fun getSchedule(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("month") month: Int,
        @Query("year") year: Int,
        @Query("method") method: Int = 2
    ): PrayerScheduleResponse
}