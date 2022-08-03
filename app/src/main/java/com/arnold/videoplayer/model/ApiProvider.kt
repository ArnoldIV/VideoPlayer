package com.arnold.videoplayer.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {
    private val openVideo : Retrofit by lazy { initApi() }

    private fun initApi() = Retrofit.Builder()
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://commondatastorage.googleapis.com/")
        .build()

    fun provideVideoApi() : VideoApi = openVideo.create(VideoApi::class.java)
}