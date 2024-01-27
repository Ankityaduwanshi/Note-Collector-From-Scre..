package com.example.notecollector.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.notecollector.activity.DeleteConfirmation
import com.example.notecollector.activity.ReadAndUpdate
import com.example.notecollector.dataBase.NoteData
import java.time.format.DateTimeFormatter
import com.example.notecollector.utilities.ColorManger

@Composable
fun CardCreator(noteData: NoteData, remove: (NoteData) -> Unit) {

    // Use for delete popup
    var popShow by remember {
        mutableStateOf(false)
    }
    var popShowconfirmation by remember {
        mutableStateOf(false)
    }

    if (popShow) {
        DeleteConfirmation(
            popShow = { it -> popShow = it },
            confirmation = { it -> popShowconfirmation = it })
    }

    // use for read and update popup

    var readShow by remember {
        mutableStateOf(false)
    }

    if (readShow){
        ReadAndUpdate(noteData = noteData, readShow = {it -> readShow = it})
    }


    //Ui Part

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clickable {
                readShow = true
            },
        shape = RoundedCornerShape(topEnd = 36.dp, bottomStart = 36.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = noteData.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.width(300.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row {

                    //Delete process
                    Icon(imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete icon",
                        modifier = Modifier.clickable {
                            popShow = true
                        })
                    if (popShowconfirmation) {
                        remove(noteData)
                        popShowconfirmation = false
                    }
                }
            }

            Text(
                text = noteData.description,
                modifier = Modifier.width(300.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


            Text(
                text = noteData.dateTime.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")),
                fontFamily = FontFamily.Cursive,
                style = MaterialTheme.typography.labelMedium
            )


        }


    }

}

