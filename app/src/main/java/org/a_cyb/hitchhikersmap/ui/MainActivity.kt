@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.AndroidEntryPoint
import org.a_cyb.hitchhikersmap.MainNavigation
import org.a_cyb.hitchhikersmap.ui.theme.HitchhikersMapTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HitchhikersMapTheme{
                window.statusBarColor = MaterialTheme.colors.background.toArgb()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainNavigation()
                }
            }
        }
    }
}

