package com.bhavesh.vridapp.data.repository

import com.bhavesh.vridapp.data.remote.api.VridApi
import com.bhavesh.vridapp.data.remote.dto.VridDto
import com.bhavesh.vridapp.domain.repository.VridRepository
import javax.inject.Inject

class VridRepositoryImp @Inject constructor(
    private val vridApi: VridApi
):VridRepository {
    override suspend fun getVridDto(): VridDto {
        return vridApi.getBlogs(10,1)
    }
}
