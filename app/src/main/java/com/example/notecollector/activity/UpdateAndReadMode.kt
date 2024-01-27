package com.example.notecollector.activity

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.room.Delete
import com.example.notecollector.dataBase.NoteData

@Composable
fun ReadAndUpdate(noteData: NoteData,readShow:(Boolean)->Unit){
    Popup( properties = PopupProperties(focusable = true)) {
        Surface (modifier = Modifier.fillMaxSize(),
            color = Color.Black.copy(alpha = 0.5f)){

            Card (modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)){

                Row (modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.End){

                    Icon(imageVector = Icons.Rounded.Close, contentDescription = "Close icon",
                        modifier = Modifier.clickable {
                            readShow(false)
                        })
                }


                Column (modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    var title by remember {
                        mutableStateOf(noteData.title)
                    }

                    var description by remember {
                        mutableStateOf(noteData.description)
                    }

                    OutlinedTextField(value = title,
                        onValueChange ={title = it},
                        label = { Text(text = "Title")},
                        keyboardActions = KeyboardActions.Default,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        enabled = true,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth())


                    OutlinedTextField(value = description,
                        onValueChange ={description = it},
                        label = { Text(text = "Description")},
                        keyboardActions = KeyboardActions.Default,
                        enabled = true,
                        maxLines = 12,
                        modifier = Modifier
                            .fillMaxWidth())

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(onClick = {
                        noteData.title = title
                        noteData.description = description
                        readShow(false)
                    }) {
                        Text(text = "Update")
                    }
                }

            }

        }
        
    }

}