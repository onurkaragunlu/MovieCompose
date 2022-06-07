package com.onurkaragunlu.moviecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.onurkaragunlu.core.ui.theme.MovieTheme
import com.onurkaragunlu.moviecompose.navigation.BottomNavItem
import com.onurkaragunlu.moviecompose.navigation.MovieAppNavigation
import com.onurkaragunlu.moviecompose.navigation.TOP_LEVEL_DESTINATIONS
import com.onurkaragunlu.moviecompose.navigation.MovieTopLevelNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                MovieAppScreen()
            }
        }
    }

    @Composable
    private fun MovieAppScreen() {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val movieTopLevelNavigation = remember(navController) {
            MovieTopLevelNavigation(navController)
        }
        val currentDestination = navBackStackEntry?.destination
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(bottomBar = {
                MovieBottomNavigation(
                    currentDestination,
                    movieTopLevelNavigation::navigateTo
                )
            }
            ) {
                MovieAppNavigation(navController)
            }
        }
    }
}

@Composable
fun MovieBottomNavigation(
    currentDestination: NavDestination?,
    onBottomMenuClick: (BottomNavItem) -> Unit
) {
    BottomNavigation() {
        TOP_LEVEL_DESTINATIONS.forEach { item ->
            val selected =
                currentDestination?.hierarchy?.any { item.route == currentDestination.route } == true
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.iconTextId)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.iconTextId)
                    )
                },
                onClick = {
                    onBottomMenuClick(item)
                },
                selected = selected,
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
            )
        }
    }
}


