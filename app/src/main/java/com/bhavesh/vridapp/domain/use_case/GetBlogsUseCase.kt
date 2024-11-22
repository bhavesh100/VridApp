package com.bhavesh.vridapp.domain.use_case

import com.bhavesh.vridapp.common.Resource
import com.bhavesh.vridapp.data.remote.dto.VridDtoItem
import com.bhavesh.vridapp.domain.repository.VridRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(
    private val vridRepository: VridRepository
) {
    operator fun invoke(): Flow<Resource<List<VridDtoItem>>> = flow {
        try {
            emit(Resource.Loading())
            val blogs:MutableList<VridDtoItem> = mutableListOf()
            vridRepository.getVridDto().onEach {
                blogs.add(it)
            }
            emit(Resource.Success(blogs))
        } catch (e:HttpException){
            emit(Resource.Error(e.message()))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}