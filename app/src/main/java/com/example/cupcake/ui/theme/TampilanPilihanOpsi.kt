package com.example.cupcake.ui.theme

import TampilanPesananModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.ui.theme.components.FormattedPriceLabel


@Composable
fun TampilanPesananModel(
    subtotal: String,
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    onCancleButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
){
    var selectedValue by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        Column {
            options.forEach { item ->
                Row {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
            FormattedPriceLabel(
                subtotal = subtotal,
                modifier = Modifier
                    .align(Alignment.End)
            )
        }
        Row {
            OutlinedButton(
                onClick = { onCancleButtonClicked }
            ) {
                Text(text = "Cancle")
            }
            Button(
                enabled = selectedValue.isNotEmpty(),
                onClick = { onNextButtonClicked }
            ) {
                Text(text = "Next")
            }
        }
    }
}


@Preview
@Composable
fun SelectOptionPreview(){
    TampilanPesananModel(
        subtotal = "299.99",
        options = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
        modifier = Modifier.fillMaxHeight()
    )
}