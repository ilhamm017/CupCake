package com.example.cupcake.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun TampilanAwal(
    quantityOptions: List<Pair<Int, Int>>,
    onNextClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        Column {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Text(text = "Order")
        }
        Row {
            Column {
                quantityOptions.forEach { item ->
                    SelectQuantityButton(labelResourcesId = item.first,
                        onClick = {
                        onNextClicked(item.second)
                    })
                }
            }
        }
    }
}

@Composable
fun SelectQuantityButton(
    @StringRes labelResourcesId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(onClick = onClick) {
        Text(text = "Tombol")
    }
}