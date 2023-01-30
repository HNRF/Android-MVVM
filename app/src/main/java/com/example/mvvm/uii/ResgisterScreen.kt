package com.example.mvvm.uii

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.mvvm.R
import com.example.mvvm.navigation.AppScreen

@Composable
fun ResgisterScreen(navController: NavHostController , viewModel: RegisterViewModel){

    val offset = Offset(5.0f, 10.0f)

    val emailRg :String by viewModel.emailRg.observeAsState(initial = "")
    val passwordRg :String by viewModel.passwordRg.observeAsState(initial = "")
    val phone :String by viewModel.phone.observeAsState(initial = "")
    val name :String by viewModel.name.observeAsState(initial = "")
    val registerEnable :Boolean by viewModel.registerEnable.observeAsState(initial = false)


    Box(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFFFAFEFF))) {

        Image(
            painter = painterResource(R.drawable.dev),
            contentDescription = "Login Image",
            contentScale = ContentScale.Inside
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){

            ConstraintLayout {

                val (surface, fab) = createRefs()
                val offset = Offset(5.0f, 10.0f)

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color(0xFFB6B3D6),
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)){

                        Text (
                            fontWeight = FontWeight.Medium,
                            text = "Welcome To MaiCalendar",
                            style = TextStyle(
                                fontSize =  24.sp,
                                shadow = Shadow(
                                    color = Color(0xFFF7BCB6),
                                    offset = offset,
                                    blurRadius = 3f,
                                )
                            )
                        )

                        Spacer(modifier = Modifier.padding(4.dp))
                        ResgiterFieldName(name) {viewModel.registerFields(it,passwordRg,emailRg,phone)}
                        Spacer(modifier = Modifier.padding(4.dp))
                        ResgiterFieldEmail(emailRg){viewModel.registerFields(it,name,passwordRg,phone)}
                        Spacer(modifier = Modifier.padding(4.dp))
                        ResgiterFieldPass(passwordRg) {viewModel.registerFields(it,name,emailRg,phone)}
                        Spacer(modifier = Modifier.padding(4.dp))
                        ResgiterFieldNumber(phone) {viewModel.registerFields(it,name,emailRg,passwordRg)}
                        Spacer(modifier = Modifier.padding(4.dp))
                        SignUp()

                        ClickableText(
                            text = AnnotatedString("Already have an account?"),
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow(
                                    color = Color(0xFFF7BCB6),
                                    offset = offset,
                                    blurRadius = 3f)),
                            onClick = {navController.navigate(AppScreen.Login.route)}
                        )
                    }
                }
                FloatingActionButton(
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(fab) {
                            top.linkTo(surface.top, margin = (-36).dp)
                            end.linkTo(surface.end, margin = 36.dp)
                        },
                    backgroundColor = Color(0xFFDC493A),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Icon",
                        modifier = Modifier.size(42.dp),
                        tint = Color.White
                    )
                }
            }

        }
    }
}

@Composable
fun ResgiterFieldNumber(phone: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = phone,
        onValueChange = {onTextFieldChanged},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Phone Number")},
        placeholder = { Text(text = "864 648 514") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black,
            backgroundColor = Color(0xFFeeeeee),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ResgiterFieldPass(passwordRg: String, onTextFieldChanged: (String) -> Unit) {

    TextField(
        value = passwordRg,
        onValueChange = {onTextFieldChanged},
        label = { Text(text = "Password")},
        placeholder = { Text(text = "Ejemplo123") },
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
}

@Composable
fun ResgiterFieldEmail(emailRg: String, onTextFieldChanged: (String) -> Unit) {

    TextField(
        value = emailRg,
        onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Email")},
        placeholder = { Text(text = "Ejemplo@gmail.com") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black,
            backgroundColor = Color(0xFFeeeeee),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun SignUp() {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAE96DA),
            disabledBackgroundColor = Color(0xFF635C70),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Sign Up")
    }
}

@Composable
fun ResgiterFieldName(name: String, onTextFieldChanged: (String) -> Unit) {

    TextField(
        value = name,
        onValueChange = {onTextFieldChanged},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Pepito Perez") },
        label = { Text(text = "Full Name")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black,
            backgroundColor = Color(0xFFeeeeee),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}
