package com.example.appretrofit.service

import com.example.appretrofit.model.QuakeResponse
import com.example.appretrofit.util.QuakesContants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat

interface QuakeAPI {
    companion object {
        const val DEPREMLER = "deprem/index.php"
    }
    @GET(DEPREMLER)
    fun getDepremler(
        @Query("limit") limit: String = QuakesContants.LIMIT,
        @Query("date") language: String = QuakesContants.DATE
    ): Single<QuakeResponse>
}