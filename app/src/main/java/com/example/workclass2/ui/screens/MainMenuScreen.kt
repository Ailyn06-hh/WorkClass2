package com.example.workclass2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

@Composable
fun MainMenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text("Main Menu")

        val lightPink = Color(0xFFFFC1CC)
        val strongPink = Color(0xFFE91E63)

        val buttonColors = ButtonDefaults.buttonColors(
            containerColor = lightPink,
            contentColor = strongPink
        )

        Button(
            onClick = { navController.navigate("home_screen") },
            colors = buttonColors
        ) {
            Text("Go to Home Screen")
        }

        Button(
            onClick = { navController.navigate("test_screen") },
            colors = buttonColors
        ) {
            Text("Go to Test Screen")
        }

        Button(
            onClick = { navController.navigate("interface_screen") },
            colors = buttonColors
        ) {
            Text("Go to Liverpool Interface")
        }

        Button(
            onClick = { navController.navigate("components_screen") },
            colors = buttonColors
        ) {
            Text("Go to Components Screen")
        }

        Button(
            onClick = { navController.navigate("login_screen") },
            colors = buttonColors
        ) {
            Text("Go to Login Screen")
        }

        Button(
            onClick = { navController.navigate("accounts_screen") },
            colors = buttonColors
        ) {
            Text("Go to Accounts Screen")
        }

        Button(
            onClick = { navController.navigate("manage_account_screen") },
            colors = buttonColors
        ) {
            Text("Go to Manage Account Screen")
        }

        Button(
            onClick = { navController.navigate("camera_screen") },
            colors = buttonColors
        ) {
            Text("Go to Camera Screen")
        }

        Button(
            onClick = { navController.navigate("app_screen") },
            colors = buttonColors
        ) {
            Text("Go to App Screen Calendar")
        }

        Button(
            onClick = { navController.navigate("notification_screen") },
            colors = buttonColors
        ) {
            Text("Go to Notification Screen")
        }

        Button(
            onClick = { navController.navigate("biometric_screen") },
            colors = buttonColors
        ) {
            Text("Go to Biometric Screen")
        }
    }
}
