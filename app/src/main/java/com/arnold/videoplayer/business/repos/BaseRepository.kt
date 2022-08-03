package com.arnold.videoplayer.business.repos

import com.arnold.videoplayer.model.ApiProvider
import io.reactivex.rxjava3.subjects.BehaviorSubject

abstract class BaseRepository<T>(val api:ApiProvider) {

     val dataEmitter: BehaviorSubject<T> = BehaviorSubject.create()
}