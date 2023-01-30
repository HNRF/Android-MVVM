package com.example.mvvm.uii

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController){


    Box(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFFFAFEFF))) {

        AndroidLogo(backgroundColor = MaterialTheme.colors.background, contentColor = Color(
            0xFF9B26AF
        ), padding = 30.dp)

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
                        .height(380.dp)
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
                        Create()
                        Spacer(modifier = Modifier.padding(8.dp))
                        Delete()
                        Spacer(modifier = Modifier.padding(8.dp))
                        Update()
                        Spacer(modifier = Modifier.padding(8.dp))
                        View()

                    }
                }

            }

        }
    }
}

@Composable
fun View() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAE96DA)
        )
    ) {
        Text(text = "See List")
    }
}

@Composable
fun Update() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAE96DA)
        )
    ) {
        Text(text = "Update")
    }
}

@Composable
fun Delete() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAE96DA)
        )
    ) {
        Text(text = "Delete")
    }
}

@Composable
fun Create() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAE96DA)
        )
    ) {
        Text(text = "Create")
    }
}

@Composable
fun AndroidLogo(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color,
    padding: Dp = 30.dp
    ){

    val eyes = remember { mutableStateOf(0.0f) }

    androidx.compose.foundation.Canvas(
        modifier = modifier
            .fillMaxSize()
            .padding(padding)
            .background(backgroundColor)
            .pointerInput(Unit){
                detectDragGestures (
                    onDrag = { change, dragAmount ->
                    change.consumeAllChanges()
                        eyes.value += dragAmount.x * 0.12f
                    },
                    onDragEnd = {
                        eyes.value = 0f
                    }
                        )
            }
    ){
        drawArc(
            startAngle = -180f,
            sweepAngle = 180f,
            useCenter = true,
            color = contentColor,
            size = Size(size.minDimension, size.minDimension),
            topLeft = Offset(0f,size.minDimension * 0.5f)
        )

        drawCircle(
            color = backgroundColor,
            center = Offset(size.minDimension * 0.3f + eyes.value, size.minDimension * 0.8f),
            radius = size.minDimension * 0.04f
        )

        drawCircle(
            color = backgroundColor,
            center = Offset(size.minDimension * 0.7f + eyes.value, size.minDimension * 0.8f),
            radius = size.minDimension * 0.04f
        )

        rotate(
            degrees = 340f,
            pivot = Offset(size.minDimension * 0.2f, size.minDimension * 0.4f)
        ){
            drawRoundRect(
                color = contentColor,
                size = Size(size.minDimension * 0.03f, size.minDimension * 0.22f),
                cornerRadius = CornerRadius(size.minDimension * 0.02f),
                topLeft = Offset(size.minDimension * 0.2f + (eyes.value * 0.3f), size.minDimension * 0.4f)
            )
        }

        rotate(
            degrees = 20f,
            pivot = Offset(size.minDimension * 0.8f, size.minDimension * 0.4f)
        ){
            drawRoundRect(
                color = contentColor,
                size = Size(size.minDimension * 0.03f, size.minDimension * 0.22f),
                cornerRadius = CornerRadius(size.minDimension * 0.02f),
                topLeft = Offset(size.minDimension * 0.8f + (eyes.value * 0.3f), size.minDimension * 0.4f)
            )
        }

    }
}
