package com.example.appretrofit.service

import com.example.appretrofit.model.QuakeResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuakeAPIService {

    private val BASE_URL = "https://api.orhanaydogdu.com.tr/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(QuakeAPI::class.java)

    fun getDepremler(): Single<QuakeResponse> {
        return api.getDepremler()
    }
}