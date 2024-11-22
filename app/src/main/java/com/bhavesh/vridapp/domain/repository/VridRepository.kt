package com.bhavesh.vridapp.domain.repository

import com.bhavesh.vridapp.data.remote.dto.VridDto

interface VridRepository {
    suspend fun getVridDto(): VridDto
}