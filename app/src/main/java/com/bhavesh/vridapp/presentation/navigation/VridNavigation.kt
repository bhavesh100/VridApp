package com.bhavesh.vridapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bhavesh.vridapp.presentation.blog_screen.BlogsScreen
import com.bhavesh.vridapp.presentation.blog_web_view.BlogWebViewScreen
import java.net.URLEncoder

@Composable
fun VridNavigation(paddingValues: PaddingValues){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.BlogScreen.route){
        composable(Routes.BlogScreen.route){
            BlogsScreen(paddingValues = paddingValues){link->
                val urlEncoder = URLEncoder.encode(link,"UTF-8")
                navController.navigate(Routes.BlogWebView.route+"/$urlEncoder")
            }
        }
        composable(
            Routes.BlogWebView.route+"/{link}",
            arguments = listOf(navArgument("link",){ type = NavType.StringType})
        ){ backStackEntry ->
            val link = backStackEntry.arguments?.getString("link").toString()
            BlogWebViewScreen(link = link, paddingValues)
        }
    }
}