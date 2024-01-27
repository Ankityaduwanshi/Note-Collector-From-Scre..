package com.example.notecollector.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TopBar(){

    Surface (modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(bottom = 12.dp),
        shadowElevation = 4.dp) {
        Row (modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically){

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Note Collector",
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = FontFamily.Cursive)

        }

    }
}