package com.example.notecollector

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notecollector.activity.NoteScreen
import com.example.notecollector.dataBase.NoteData
import com.example.notecollector.dataBase.ViewModelNote
import com.example.notecollector.ui.theme.NoteCollectorTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent


@AndroidEntryPoint
class MainActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteCollectorTheme { ;
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModelNote: ViewModelNote by viewModels()

                    Start(viewModelNote = viewModelNote)
                }
            }
        }
    }
}

@Composable
fun Start(viewModelNote:ViewModelNote){

    val dataList = viewModelNote.noteList.collectAsState().value

    NoteScreen(dataList = dataList,
        add = {noteData->
            viewModelNote.add(noteData = noteData)
        }, remove = {noteData->
           viewModelNote.remove(noteData)
        })



}