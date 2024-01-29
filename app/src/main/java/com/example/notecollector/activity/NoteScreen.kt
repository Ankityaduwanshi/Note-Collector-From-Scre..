package com.example.notecollector.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.notecollector.component.CardCreator
import com.example.notecollector.component.EntryField
import com.example.notecollector.component.TopBar
import com.example.notecollector.dataBase.NoteData

@Composable
fun NoteScreen(dataList: List<NoteData>, add: (NoteData) -> Unit, remove: (NoteData) -> Unit) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar()
            EntryField(
                value = title,
                onValueChange = { title = it },
                lable = "Title",
                placeholder = "Enter your Title",
                maxLine = 2
            )
            EntryField(
                value = description,
                onValueChange = { description = it },
                lable = "Description",
                placeholder = "Enter your Description",
                maxLine = 4,
                imeAction = ImeAction.Default,
                modifier = Modifier.imePadding()
            )

            Button(onClick = {
                if ((title.trim()).isNotEmpty() && (description.trim()).isNotEmpty()) {
                    add(NoteData(title = title, description = description))
                    title = ""
                    description = ""
                }

            }) {
                Text(text = "Save")

            }

            Divider(modifier = Modifier.padding(12.dp))

            LazyColumn {
                items(dataList) { note ->

                    CardCreator(noteData = note, remove)


                }

            }

        }
    }

}



