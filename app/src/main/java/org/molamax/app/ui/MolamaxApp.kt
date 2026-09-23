package org.molamax.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.molamax.app.ui.components.MolaDestination
import org.molamax.app.ui.screens.ContactScreen
import org.molamax.app.ui.screens.HomeScreen
import org.molamax.app.ui.screens.LearnScreen
import org.molamax.app.ui.screens.ProductsScreen
import org.molamax.app.ui.screens.StockistsScreen
import org.molamax.app.ui.theme.MolaRed

@Composable
fun MolamaxApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            NavigationBar {
                MolaDestination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(destination.icon, contentDescription = destination.label) },
                        label = { Text(destination.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MolaRed,
                            selectedTextColor = MolaRed,
                            indicatorColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MolaDestination.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MolaDestination.Home.route) {
                HomeScreen(onExploreProducts = {
                    navController.navigate(MolaDestination.Products.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
            }
            composable(MolaDestination.Products.route) { ProductsScreen() }
            composable(MolaDestination.Learn.route) { LearnScreen() }
            composable(MolaDestination.Stockists.route) { StockistsScreen() }
            composable(MolaDestination.Contact.route) { ContactScreen() }
        }
    }
}
