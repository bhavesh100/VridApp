package com.bhavesh.vridapp.presentation.blog_web_view

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.bhavesh.vridapp.presentation.navigation.Routes
import java.net.URLDecoder

@Composable
fun BlogWebViewScreen(link: String, paddingValues: PaddingValues ,webViewClient: WebViewClient = WebViewClient()){
    AndroidView(
        modifier = Modifier
            .padding(paddingValues = paddingValues),
        factory = { context ->
            WebView(context).apply {
                this.webViewClient = webViewClient
            }
        },
        update = { webView ->
            webView.loadUrl(URLDecoder.decode(link,"Utf-8"))
        }
    )
}