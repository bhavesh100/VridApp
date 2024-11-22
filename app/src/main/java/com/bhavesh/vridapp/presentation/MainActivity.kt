package com.bhavesh.vridapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bhavesh.vridapp.R
import com.bhavesh.vridapp.presentation.blog_screen.BlogsScreen
import com.bhavesh.vridapp.presentation.blog_screen.BlogsViewModel
import com.bhavesh.vridapp.presentation.navigation.VridNavigation
import com.bhavesh.vridapp.ui.theme.VridAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VridAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar(title = {
                        Text(text = stringResource(id = R.string.app_name))
                    })}
                ) { innerPadding ->
                    VridNavigation(paddingValues = innerPadding)
                }
            }
        }
    }
}