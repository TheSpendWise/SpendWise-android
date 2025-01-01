package com.geekymusketeers.spendwise_android.presentation

import com.geekymusketeers.spendwise_android.R

data class OnBoardingItem(
    val title: String,
    val text: String,
    val image: Int
) {
    companion object {
        fun onboardingScreenItems() = listOf(
            OnBoardingItem(
                "Title goes here",
                "The short description goes here like a long text.",
                R.drawable.ic_launcher_foreground
            ),
            OnBoardingItem(
                "Title goes here",
                "The short description goes here like a long text.",
                R.drawable.ic_launcher_foreground
            ),
            OnBoardingItem(
                "Title goes here",
                "The short description goes here like a long text.",
                R.drawable.ic_launcher_foreground
            ),
        )
    }
}