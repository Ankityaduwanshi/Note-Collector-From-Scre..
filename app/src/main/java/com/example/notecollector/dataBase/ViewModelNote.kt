package com.example.notecollector.dataBase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notecollector.repo.repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ViewModelNote @Inject constructor(private val repo: repo):ViewModel(){

    private var note = MutableStateFlow<List<NoteData>>(emptyList())

    val noteList = note.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            repo.getAll().distinctUntilChanged().collect{list->

                if (list.isEmpty()) {
                    note.value= emptyList()
                } else {
                    note.value = list
                }
            }
        }
    }



   fun add(noteData: NoteData) = viewModelScope.launch { repo.insert(noteData) }



    fun remove(noteData: NoteData) = viewModelScope.launch { repo.delete(noteData) }




}