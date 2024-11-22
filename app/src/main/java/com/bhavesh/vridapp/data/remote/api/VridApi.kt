package com.bhavesh.vridapp.data.remote.api

import com.bhavesh.vridapp.data.remote.dto.VridDto
import retrofit2.http.GET
import retrofit2.http.Query

interface VridApi {
    @GET("posts")
    suspend fun getBlogs(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): VridDto
}