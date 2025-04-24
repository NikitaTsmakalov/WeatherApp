package com.example.weatheuiapp.presentation.screen.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatheruiapp.R

@Composable
fun IconPreviewBox(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.snowy),
                contentDescription = "Snowy",
                modifier = Modifier.size(48.dp),
                tint = Color.White
            )
            Text(
                text = "Snowy",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.storm),
                contentDescription = "Storm",
                modifier = Modifier.size(48.dp),
                tint = Color.White
            )
            Text(
                text = "Storm",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.sunny),
                contentDescription = "Sunny",
                modifier = Modifier.size(48.dp),
                tint = Color.White
            )
            Text(
                text = "Sunny",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.windy),
                contentDescription = "Windy",
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = "Windy",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconPreviewBoxPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        IconPreviewBox(
            modifier = Modifier
                .align(Alignment.Center)
                .width(300.dp)
                .height(100.dp)
        )
    }
}