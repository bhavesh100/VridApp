package com.bhavesh.vridapp.presentation.navigation

sealed class Routes(val route: String) {
    object BlogScreen: Routes("blog_screen")
    object BlogWebView: Routes("blog_web_view")
}