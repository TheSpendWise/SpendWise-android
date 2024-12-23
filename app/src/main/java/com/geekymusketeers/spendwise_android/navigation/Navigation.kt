package com.geekymusketeers.spendwise_android.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.geekymusketeers.spendwise_android.presentation.OnboardingScreen
import com.geekymusketeers.spendwise_android.presentation.SplashScreen
import com.geekymusketeers.spendwise_android.ui.theme.BackgroundLight
import com.geekymusketeers.spendwise_android.ui.theme.OnPrimaryContainerLight
import com.geekymusketeers.spendwise_android.ui.theme.OnSurfaceVariantLight
import com.geekymusketeers.spendwise_android.ui.theme.PrimaryDark

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()

    val screenWithoutNavigationBar = listOf(
        Screens.AddReceiptScreen.name
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        bottomBar = {
            BottomNavigation(
                backStackEntry,
                screenWithoutNavigationBar,
                navController
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.SplashScreen.name
        ) {
            composable(route = Screens.SplashScreen.name) {
                SplashScreen()
            }

            composable(route = Screens.OnboardingScreen.name) {
                OnboardingScreen()
            }
        }
    }
}

@Composable
fun BottomNavigation(
    backStackEntry: State<NavBackStackEntry?>,
    screenWithoutNavigationBar: List<String>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    if (backStackEntry.value?.destination?.route !in screenWithoutNavigationBar) {
        NavigationBar(
            modifier = modifier,
            containerColor = BackgroundLight
        ) {

            val bottomNavItems = listOf(
                BottomNavItem(
                    name = "Vault",
                    route = "vault_screen",
                    icon = Icons.Default.Home
                ),
//                BottomNavItem(
//                    name = "Browse",
//                    route = "home_screen",
//                    icon = ImageVector.vectorResource(id = R.drawable.browse)
//                ),
                BottomNavItem(
                    name = "Tools",
                    route = "tools_screen",
                    icon = Icons.Default.DateRange
                ),
                BottomNavItem(
                    name = "Profile",
                    route = "profile_screen",
                    icon = Icons.Default.Settings
                )
            )

            bottomNavItems.forEach { item ->
                val isSelected = backStackEntry.value?.destination?.route == item.route
                val animateIconSize by animateFloatAsState(
                    if (isSelected) 1f else 0.9f,
                    label = "iconScale"
                )

                NavigationBarItem(
                    alwaysShowLabel = true,
                    icon = {
                        Icon(
                            modifier = Modifier.scale(animateIconSize),
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = if (isSelected)
                                OnPrimaryContainerLight
                            else
                                OnSurfaceVariantLight
                        )
                    },
                    label = {
                        Text(
                            text = item.name,
                            color = if (isSelected)
                                OnPrimaryContainerLight
                            else
                                OnSurfaceVariantLight,
                            fontWeight = if (isSelected)
                                FontWeight.SemiBold
                            else
                                FontWeight.Normal,
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (item.route != currentDestination) {
                            navController.navigate(item.route) {
                                navController.graph.findStartDestination().let { route ->
                                    popUpTo(route.id) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = PrimaryDark
                    )
                )
            }
        }
    }
}
