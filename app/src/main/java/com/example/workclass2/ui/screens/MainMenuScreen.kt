package com.example.workclass2.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainMenuScreen(navController: NavHostController) {
    val lightPink = Color(0xFFFFE4EC)  // Rosa pálido
    val darkPink = Color(0xFFC2185B)   // Rosa oscuro

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espaciado entre botones
    ) {
        Text("Main Menu", fontSize = MaterialTheme.typography.headlineSmall.fontSize)

        Button(
            onClick = { navController.navigate("home_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Home Screen")
        }

        Button(
            onClick = { navController.navigate("test_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Test Screen")
        }

        Button(
            onClick = { navController.navigate("interface_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Liverpool App")
        }

        Button(
            onClick = { navController.navigate("components_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Components Screens")
        }

        Button(
            onClick = { navController.navigate("Login_Screen") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Login Screen")
        }

        Button(
            onClick = { navController.navigate("apiCamera") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Api Camera")
        }

        Button(
            onClick = { navController.navigate("apiContactsCalendar") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Contacts and Calendar Api")
        }

        Button(
            onClick = { navController.navigate("apiPush") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Push Notifications")
        }

        Button(
            onClick = { navController.navigate("biometric_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = lightPink, contentColor = darkPink)
        ) {
            Text("Go to Biometric Sensor")
        }
    }
}
