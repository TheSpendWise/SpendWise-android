package com.geekymusketeers.spendwise_android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekymusketeers.spendwise_android.R
import com.geekymusketeers.spendwise_android.ui.theme.OnSecondaryContainerLight
import com.geekymusketeers.spendwise_android.ui.theme.SecondaryContainerLight

@Composable
fun GoogleSSOComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecondaryContainerLight)
            .then(modifier),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clickable { onClick() }
                .background(Color.White, shape = RoundedCornerShape(100.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "Google Logo",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp),
            )
            Text(
                text = "Sign in with Google",
                fontSize = 16.sp,
                color = OnSecondaryContainerLight
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "By signing in you agree with our terms and conditions",
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

}