package com.bwahyuh.quranme.repo.remote.network

import com.bwahyuh.quranme.repo.remote.response.AyahResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranService {

    @GET("surat/{no}")
    suspend fun getSurah(
        @Path("no") no: Int,
    ): List<AyahResponse>
}