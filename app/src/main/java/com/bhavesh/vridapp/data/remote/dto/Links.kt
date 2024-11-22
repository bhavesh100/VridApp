package com.bhavesh.vridapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Links(
    val about: List<About>,
    val author: List<Author>,
    val collection: List<Collection>,
    val curies: List<Cury>,
    @SerializedName("predecessor-version")
    val predecessorversion: List<PredecessorVersion>,
    val replies: List<Reply>,
    val self: List<Self>,
    @SerializedName("version-history")
    val versionhistory: List<VersionHistory>,
    @SerializedName("wp:attachment")
    val wpattachment: List<WpAttachment>,
    @SerializedName("wp:featuredmedia")
    val wpfeaturedmedia: List<WpFeaturedmedia>,
    @SerializedName("wp:term")
    val wpterm: List<WpTerm>
)