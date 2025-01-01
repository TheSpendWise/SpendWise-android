package com.geekymusketeers.spendwise_android.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aritradas.uncrack.ui.theme.bold22
import com.aritradas.uncrack.ui.theme.medium16
import com.aritradas.uncrack.ui.theme.medium18
import com.geekymusketeers.spendwise_android.R
import com.geekymusketeers.spendwise_android.component.GoogleSSOComponent
import com.geekymusketeers.spendwise_android.ui.theme.OnPrimaryContainerLight
import com.geekymusketeers.spendwise_android.ui.theme.OnSurfaceVariantLight
import com.geekymusketeers.spendwise_android.ui.theme.PrimaryDark

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {

    val pages = OnBoardingItem.onboardingScreenItems()
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    Scaffold(
        bottomBar = {
            GoogleSSOComponent {

            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = bottomPadding
                )
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            if (pagerState.currentPage != pages.lastIndex) {
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {

                        },
                    text = stringResource(R.string.skip),
                    style = medium18
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(8f)
            ) { index ->
                OnboardingComponent(item = pages[index])
            }

            PageIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                pagesSize = pages.size,
                selectedPage = pagerState.currentPage
            )
        }
    }
}

@Composable
fun OnboardingComponent(item: OnBoardingItem, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = item.image),
            contentDescription = "onboard image",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )
        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = item.title,
            style = bold22.copy(OnPrimaryContainerLight),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = item.text,
            textAlign = TextAlign.Center,
            style = medium16
        )
    }
}

@Composable
fun PageIndicator(
    pagesSize: Int,
    selectedPage: Int,
    modifier: Modifier = Modifier,
    selectedColor: Color = PrimaryDark,
    unselectedColor: Color = OnSurfaceVariantLight
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        repeat(times = pagesSize) { page ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}