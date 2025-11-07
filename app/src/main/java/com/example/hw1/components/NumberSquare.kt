package com.example.hw1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.hw1.R

@Composable
fun NumberSquare(
    number: Int,
    modifier: Modifier = Modifier
) {
    val isEven = number % 2 == 0
    val color = if (isEven) {
        colorResource(id = R.color.even_color)
    } else {
        colorResource(id = R.color.odd_color)
    }
    val fontSize = with(LocalDensity.current) {
        dimensionResource(id = R.dimen.square_text_size).toSp()
    }
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.square_corner_radius)))
            .background(color)
    ) {
        Text(
            text = number.toString(),
            color = colorResource(id = R.color.text),
            fontSize = fontSize,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}