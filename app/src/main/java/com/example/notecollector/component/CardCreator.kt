package com.example.notecollector.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.notecollector.dataBase.NoteData
import java.time.format.DateTimeFormatter

@Composable
fun CardCreator(noteData: NoteData,remove: (NoteData)->Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        shape = RoundedCornerShape(topEnd = 36.dp, bottomStart = 36.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = noteData.title, style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.width(300.dp), maxLines = 1, overflow = TextOverflow.Ellipsis)
                Row {
                    Icon(imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete icon",
                        modifier = Modifier.clickable { remove(noteData) })
                }
            }

            Text(text = noteData.description,
                modifier = Modifier.width(300.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)


            Text(text = noteData.dateTime.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")),
                fontFamily = FontFamily.Cursive,
                style = MaterialTheme.typography.labelMedium)


        }


    }

}