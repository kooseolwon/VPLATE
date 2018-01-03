package com.vplate.community.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager
import com.vplate.community.adapter.holders.VideoViewHolder
import com.vplate.community.adapter.items.BaseVideoItem

class VideoRecyclerViewAdapter(private val mVideoPlayerManager: VideoPlayerManager<*>, private val mContext: Context, private val mList: List<BaseVideoItem>) : RecyclerView.Adapter<VideoViewHolder>() {
    private val lastPosition: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): VideoViewHolder {
        val videoItem = mList[position]
        val resultView = videoItem.createView(viewGroup, mContext.resources.displayMetrics.widthPixels)
        return VideoViewHolder(resultView)
    }

    override fun onBindViewHolder(viewHolder: VideoViewHolder, position: Int) {
        /*setAnimation(viewHolder.mCardView, position);*/

        val videoItem = mList[position]
        videoItem.update(position, viewHolder, mVideoPlayerManager)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    /*private void setAnimation(View viewToAnimate, int position) {
        // 새로 보여지는 뷰라면 애니메이션
        if (position > lastPosition) {
            YoYo.with(Techniques.FadeInLeft).playOn(viewToAnimate);
            lastPosition = position;
        }
        else {
            YoYo.with(Techniques.FadeOutRight).playOn(viewToAnimate);
            lastPosition = position;
        }
    }*/
}
