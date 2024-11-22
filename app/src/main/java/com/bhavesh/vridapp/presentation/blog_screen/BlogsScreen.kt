package com.bhavesh.vridapp.presentation.blog_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.bhavesh.vridapp.data.remote.dto.VridDtoItem

@Composable
fun BlogsScreen(
    viewModel: BlogsViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    onclick :(String) -> Unit
){
    val blogsState = viewModel.state
    if (blogsState.value.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            LinearProgressIndicator()
        }
    } else if (blogsState.value.blogs.isNotEmpty()){
        val blogs: List<VridDtoItem> = blogsState.value.blogs
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            blogs.forEach {
                item {
                    BlogItem(it){
                        onclick(it)
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    } else if (blogsState.value.error.isNotEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = blogsState.value.error)
        }
    }
}

@Composable
fun BlogItem(vridDtoItem: VridDtoItem, onclick :(String) -> Unit){
    Row(
        Modifier.clickable {
            onclick(vridDtoItem.link)
        }
    ) {
        AsyncImage(model = vridDtoItem.jetpack_featured_media_url,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(90.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(
                text = vridDtoItem.title.rendered,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(text = vridDtoItem.date.substring(0, 10), fontSize = 10.sp)
        }

    }
}