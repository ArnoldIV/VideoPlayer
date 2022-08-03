package com.arnold.videoplayer.model

data class Video(
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String,
    val title: String
) {
    fun isNotEmpty(): Boolean {
        return true
    }

}