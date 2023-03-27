package org.a_cyb.hitchhikersmap

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.a_cyb.hitchhikersmap.ui.map.MapScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "map") {
        composable("map") { MapScreen(modifier = Modifier) }
    }
}