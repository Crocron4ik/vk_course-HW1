package com.example.hw1.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.hw1.R

private const val COLUMNS_PORTRAIT = 3
private const val COLUMNS_LANDSCAPE = 4

@Composable
fun MyScreen() {
    val count = rememberSaveable { mutableIntStateOf(0) }
    val columnsCount =
        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
            COLUMNS_PORTRAIT
        } else {
            COLUMNS_LANDSCAPE
        }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columnsCount),
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = dimensionResource(id = R.dimen.grid_padding_horizontal),
                    end = dimensionResource(id = R.dimen.grid_padding_horizontal),
                    bottom = dimensionResource(id = R.dimen.grid_padding_bottom)
                ),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.grid_spacing)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.grid_spacing))
        ) {
            items(count.intValue, key = { it }) { item ->
                val number = item + 1
                val isLast = number == count.intValue
                NumberSquare(
                    number = number,
                    lastClick = {
                        if (isLast) {
                            count.intValue--
                        }
                    })
            }
        }
        FloatingActionButton(
            onClick = { count.intValue++ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(dimensionResource(id = R.dimen.fab_padding))
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.add_item)
            )
        }
    }
}
