package com.example.mvvm.uii.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.data.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class CreateViewModel {
    val db = FirebaseFirestore.getInstance()

    private val notedb = Firebase ()

    private val _note = MutableLiveData<String>()
    val note:  LiveData<String> = _note

    private val _date = MutableLiveData<String>()
    val date:  LiveData<String> = _date

    fun setNote (note: String){
        _note.value = note
    }
    fun setDate (date: String){
        _date.value = date
    }

    fun createNote(){

       notedb.createNote(_note.value.toString(), _date.value.toString()){
        }



    }






}