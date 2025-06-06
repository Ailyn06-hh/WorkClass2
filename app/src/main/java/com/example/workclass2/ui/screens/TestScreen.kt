package com.example.workclass2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass2.R


import com.example.workclass2.ui.screens.HomeScreen


@Composable
fun TestScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) //Para poder tener scroll de manera vertical

    ) {
        Text("Test Screen")
        Button(
            onClick = { navController.navigate("main_menu")}

        ) {
            Text("Return to Main Menu")
        }

        TextComposable("AIlYn")
        ModifierExample2()
        ModifierExample2()
        ModifierExample3()
        ModifierExample4()
        CustomText()
        Picture()
    }
}


@Preview(showBackground = true)
@Composable
fun TextComposable(name: String = "Empty") {
    Text("Welcome")
    Text(name)
}
@Preview(showBackground = true)
@Composable
fun ModifierExample1(){
    Column (
        modifier = Modifier
            .padding(40.dp,30.dp,20.dp,10.dp)//Izquierda,Arriba,Derecha y Abajo
    ){
        Text("Hello World")
    }
}
@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable (onClick = {clickAction() }
            )
    ){
        Text("Hello World")
    }
}


fun clickAction (){
    println("Column Clicked")
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Cyan)
            .border(width = 2.dp,color= Color.Black)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly


    ) {
        TextComposable("1")
        TextComposable("2")
        TextComposable("3")
        TextComposable("4")

    }



}

@Preview(showBackground = true)
@Composable
fun ModifierExample4() { //Es una caja donde tenemos 9 numeros
    Box (
        modifier = Modifier
            .background(Color.Red)
            .padding(10.dp)
            .width(300.dp)
            .height(300.dp)
    ){
        Text("1",Modifier.align(Alignment.TopStart))//
        Text("2",Modifier.align(Alignment.TopCenter))
        Text("3",Modifier.align(Alignment.TopEnd))
        Text("4",Modifier.align(Alignment.CenterStart))
        Text("5",Modifier.align(Alignment.Center))
        Text("6",Modifier.align(Alignment.CenterEnd))
        Text("7",Modifier.align(Alignment.BottomStart))
        Text("8",Modifier.align(Alignment.BottomCenter))
        Text("9",Modifier.align(Alignment.BottomEnd))








    }
}

@Preview(showBackground = true)
@Composable
fun CustomText(name: String = "Empty") { //Texto con un diseño diferente
    Column () {

        Text(
            stringResource(R.string.Sample_Text),
            color = colorResource(R.color.purple_500),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Color.Cyan, Color.Red, colorResource(R.color.purple_500)) //Una lista de colores que sera el tipo arcoiris dentro del texto
        Text(
            stringResource(R.string.Sample_Text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))//Nos permite hacer un degradado de color

        )
    }
}
@Preview(showBackground = true) //Funcion para mostrar una imagen
@Composable
fun Picture(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(300.dp)
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.geto),
            contentDescription = "En un mundo como este... no puedo reírme desde el fondo de mi corazón",
            contentScale = ContentScale.Crop //La forma que tomara la imagen recortada, amplia, etc
        )
    }
}

