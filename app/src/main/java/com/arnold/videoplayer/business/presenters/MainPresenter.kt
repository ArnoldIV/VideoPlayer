package com.arnold.videoplayer.business.presenters

import com.arnold.videoplayer.business.repos.MainRepository
import com.arnold.videoplayer.model.ApiProvider
import com.arnold.videoplayer.view.MainView

class MainPresenter : BasePresenter<MainView>() {

    private val repo = MainRepository(ApiProvider())

    override fun enabled() {
        repo.dataEmitter.subscribe{ response ->
            viewState.displayDataAboutVideo(response.videoData)
            response.error?.let{viewState.displayError(response.error)}
        }

    }
    fun refresh(title: String,sources: List<String>, description: String,subtitle: String,
                thumb: String ){
        viewState.setLoading(true)
        repo.reloadData(title,sources, description, subtitle, thumb)
    }

}