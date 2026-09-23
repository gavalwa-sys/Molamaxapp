package org.molamax.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Science
import androidx.compose.ui.graphics.vector.ImageVector

enum class MolaDestination(val route: String, val label: String, val icon: ImageVector) {
    Home("home", "Home", Icons.Filled.Home),
    Products("products", "Products", Icons.Filled.Science),
    Learn("learn", "Learn", Icons.Filled.MenuBook),
    Stockists("stockists", "Stockists", Icons.Filled.Place),
    Contact("contact", "Contact", Icons.Filled.Chat)
}
