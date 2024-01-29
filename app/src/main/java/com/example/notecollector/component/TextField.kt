package com.example.notecollector.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction

@Composable
fun EntryField(modifier: Modifier = Modifier,
               value: String,
               onValueChange:(String)-> Unit,
               lable : String,
               placeholder:String,
               maxLine:Int = 1,
               imeAction: ImeAction = ImeAction.Next){

    TextField(value = value,
        onValueChange = onValueChange,
        label = { Text(text = lable) },
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        maxLines = maxLine,
        enabled = true,
        modifier= modifier,
        colors = TextFieldDefaults.colors(focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent)

        )


}