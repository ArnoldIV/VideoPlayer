package com.arnold.videoplayer.model


import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApi {

    @GET("gtv-videos-bucket/sample/")
    fun getVideo(
        @Query("description") description : String,
        @Query("sources") sources : List<String>,
        @Query("subtitle") subtitle : String,
        @Query("thumb") thumb : String,
        @Query("title") title : String
   ) : Observable<List<Video>>

}