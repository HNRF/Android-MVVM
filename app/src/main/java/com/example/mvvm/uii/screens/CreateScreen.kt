package com.example.mvvm.uii.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mvvm.uii.viewmodel.CreateViewModel
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun CreateScreen(navController: NavHostController, CreateViewModel: CreateViewModel){

    val db = FirebaseFirestore.getInstance()
    val note :String by CreateViewModel.note.observeAsState(initial = "")
    val date :String by CreateViewModel.date.observeAsState(initial = "")

    val offset = Offset(5.0f, 10.0f)

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 112.dp,
        backgroundColor = Color.White,
        contentColor = Color(0xFFB6B3D6),
        border = BorderStroke(1.dp, Color(0xFF8D87D1))
        ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .padding(start = 10.dp)
                .padding(end = 10.dp)
                ){

            Text(
                text= "Create a Note",
                style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    shadow = Shadow(
                        color = Color(0xFFF7BCB6),
                        offset = offset,
                        blurRadius = 3f)
                )
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextField(
                value = note,
                onValueChange = {CreateViewModel.setNote(it)},
                label = { Text(text = "Note")},
                placeholder = { Text(text = "Do homework") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(textColor = Color.Black,
                    backgroundColor = Color(0xFFeeeeee),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.size(5.dp))

            TextField(
                value = date,
                onValueChange = {CreateViewModel.setDate(it)},
                label = { Text(text = "Date")},
                placeholder = { Text(text = "00/00/0000") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(textColor = Color.Black,
                    backgroundColor = Color(0xFFeeeeee),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.size(5.dp))


            Button(onClick = { CreateViewModel.createNote()
            }) {
                Text(text = "SAFEEE!!")
            }
        }
    }

}


