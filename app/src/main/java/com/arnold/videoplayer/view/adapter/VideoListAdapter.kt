package com.arnold.videoplayer.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import butterknife.BindView
import butterknife.ButterKnife
import com.arnold.videoplayer.R
import com.arnold.videoplayer.model.Video


class VideoListAdapter : BaseAdapter<Video>(){

    lateinit var clickListener: VideoItemClick


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video_list, parent,false)
        return VideoViewHolder(view)
    }

    interface VideoItemClick{
        fun showVideo(data: Video)
    }

    inner class VideoViewHolder(view: View) : BaseViewHolder(view) {

        @BindView(R.id.cardView)
        lateinit var container: CardView

        @BindView(R.id.titleTextView)
        lateinit var titleView: TextView

        @BindView(R.id.subTitleTextView)
        lateinit var subtitleView: TextView

        @BindView(R.id.movieImageView)
        lateinit var movieImageView: ImageView


        init {
            ButterKnife.bind(this, itemView)
        }

        override fun bindView(position: Int) {
            val itemData = mData[position]

            container.setOnClickListener{
                clickListener.showVideo(itemData)
            }

            mData[position].apply {
                titleView.text = title
                subtitleView.text = subtitle
                movieImageView.setImageResource(R.drawable.ic_next)
            }

        }
    }

}