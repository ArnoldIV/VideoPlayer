package com.arnold.videoplayer

import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import com.arnold.videoplayer.business.presenters.MainPresenter
import com.arnold.videoplayer.model.Video
import com.arnold.videoplayer.view.MainView
import com.arnold.videoplayer.view.adapter.VideoListAdapter
import kotlinx.android.synthetic.main.activity_main.*

import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private val mainPresenter by moxyPresenter{ MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            adapter = VideoListAdapter()
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
        }

        mainPresenter.enabled()


    }
    // -------------- Moxy --------------
    override fun displayDataAboutVideo(data: List<Video>) {
        (recyclerView.adapter as VideoListAdapter).updateData(data)

    }

    override fun displayError(data: Throwable) {
    }

    override fun setLoading(flag: Boolean) {
    }
// -------------- Moxy --------------



}