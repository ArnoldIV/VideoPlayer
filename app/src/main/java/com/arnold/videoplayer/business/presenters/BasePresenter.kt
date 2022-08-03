package com.arnold.videoplayer.business.presenters

import com.arnold.videoplayer.model.ApiProvider
import moxy.MvpPresenter
import moxy.MvpView


abstract class BasePresenter<T : MvpView> : MvpPresenter<T>() {

    abstract fun enabled()

}