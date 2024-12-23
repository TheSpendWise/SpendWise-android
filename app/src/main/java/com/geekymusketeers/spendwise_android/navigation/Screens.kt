package com.geekymusketeers.spendwise_android.navigation

sealed class Screens(val name: String) {

    data object SplashScreen: Screens("SPLASH_SCREEN")
    data object OnboardingScreen: Screens("ONBOARDING_SCREEN")
    data object HomeScreen: Screens("HOME_SCREEN")
    data object StatsScreen: Screens("STATS_SCREEN")
    data object SettingsScreen: Screens("SETTINGS_SCREEN")
    data object AddReceiptScreen: Screens("ADD_RECEIPT_SCREEN")
}