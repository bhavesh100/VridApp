package com.bhavesh.vridapp.presentation.blog_screen

import com.bhavesh.vridapp.data.remote.dto.VridDtoItem

data class BlogsState(
    val isLoading: Boolean = false,
    val blogs: List<VridDtoItem> = emptyList(),
    val error: String = ""
)
