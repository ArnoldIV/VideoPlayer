package com.arnold.videoplayer.view

import com.arnold.videoplayer.model.Video
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import retrofit2.http.Url

interface MainView : MvpView {

    @AddToEndSingle
    fun displayDataAboutVideo(data: List<Video>)

    @AddToEndSingle
    fun displayError(data: Throwable)

    @AddToEndSingle
    fun setLoading(flag: Boolean)
}