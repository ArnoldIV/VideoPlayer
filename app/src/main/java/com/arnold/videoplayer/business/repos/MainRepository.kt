package com.arnold.videoplayer.business.repos

import android.util.Log
import com.arnold.videoplayer.model.ApiProvider
import com.arnold.videoplayer.model.Video
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainRepository(api: ApiProvider) : BaseRepository<MainRepository.ServerResponse>(api) {

    data class ServerResponse(val videoData: List<Video>, val error: Throwable? = null)

    fun reloadData(
        title: String, sources: List<String>, description: String, subtitle: String,
        thumb: String
    ) {
        Observable.just(
            api.provideVideoApi().getVideo(title, sources, description, subtitle, thumb).map {
                it.asSequence()
                    .map { video ->video.title }
                    .toList()
                    .filterNotNull()
                    .first()
            }
        ) { videoData: List<Video> -> ServerResponse(videoData) }

            .subscribeOn(Schedulers.io())
            .doOnNext { /* TODO fas*/ }
            //.onErrorResumeNext {
                /* TODO asdf*/
           // }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataEmitter.onNext(it as ServerResponse)
            }, {
                Log.d("MainRepo", "reload data: $it")
            })
    }



}