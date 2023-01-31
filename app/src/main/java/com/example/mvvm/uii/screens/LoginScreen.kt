package com.example.mvvm.uii


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
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
import com.example.mvvm.navigation.AppScreen
import com.example.mvvm.R
import com.example.mvvm.uii.viewmodel.LoginViewModel


@Composable
fun LoginScreen(navController: NavHostController, LoginViewModel: LoginViewModel){

    val email :String by LoginViewModel.email.observeAsState(initial = "")
    val password :String by LoginViewModel.password.observeAsState(initial = "")



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
                        .height(400.dp)
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

                        Spacer(modifier = Modifier.padding(16.dp))

                        TextField(
                            value = email,
                            onValueChange = {LoginViewModel.onLoginChanged(it,password)},
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
                        Spacer(modifier = Modifier.padding(16.dp))

                        TextField(
                            value = password,
                            onValueChange = {LoginViewModel.onLoginChanged(email,it)},
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

                        Spacer(modifier = Modifier.padding(8.dp))

                        Button(
                            onClick = { navController.navigate("HomeScreen") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAE96DA),
                                contentColor = Color.White,
                            )
                        ) {
                            Text(text = "Sign In")
                        }
                        Spacer(modifier = Modifier.padding(8.dp))

                        ClickableText(
                           text = AnnotatedString("Do not have an Account?"),
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow(
                                    color = Color(0xFFF7BCB6),
                                    offset = offset,
                                    blurRadius = 3f)),
                            onClick = {
                                navController.navigate(AppScreen.Register.route)
                            }
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        ForgotPassword()
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
                    onClick = {navController.navigate(AppScreen.Home.route)}
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
fun ForgotPassword() {
    Text(
        text = "Forgot Password?",
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        style = MaterialTheme.typography.body1,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}
