package com.bhavesh.vridapp.presentation.blog_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.vridapp.common.Resource
import com.bhavesh.vridapp.domain.use_case.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BlogsViewModel @Inject constructor(
    val useCase: GetBlogsUseCase
): ViewModel() {
    private val _state = mutableStateOf(BlogsState())
    val state: State<BlogsState> = _state

    init {
        getBlogs()
    }
    private fun getBlogs(){
        useCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = BlogsState(blogs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = BlogsState(error = result.message ?: "error")
                }
                is Resource.Loading -> {
                    _state.value = BlogsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}