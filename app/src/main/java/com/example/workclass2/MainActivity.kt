package com.example.workclass2

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.workclass2.data.database.AppDatabase
import com.example.workclass2.data.database.DatabaseProvider
import com.example.workclass2.ui.screens.AccountsScreen
import com.example.workclass2.ui.screens.AppScreen
import com.example.workclass2.ui.screens.BiometricScreen
import com.example.workclass2.ui.screens.CameraScreen
import com.example.workclass2.ui.screens.ComponentScreen
import com.example.workclass2.ui.screens.FavoriteAccountsScreen
import com.example.workclass2.ui.screens.HomeScreen
import com.example.workclass2.ui.screens.InterfaceLiverpool
import com.example.workclass2.ui.screens.LoginScreen
import com.example.workclass2.ui.screens.MainMenuScreen
import com.example.workclass2.ui.screens.ManageAccountScreen
import com.example.workclass2.ui.screens.NotificationScreen
import com.example.workclass2.ui.screens.TestScreen
import com.example.workclass2.ui.theme.WorkClassTheme

class MainActivity : FragmentActivity() {
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try{
            database = DatabaseProvider.getDatabase(this)
            Log.d("debug-db", "Database loaded successfully")
        }catch(exception:Exception){
            Log.d("debug-db", "ERROR: $exception")
        }
        val destination = intent?.getStringExtra("destination")


        //enableEdgeToEdge()
        //Que contenido visual tiene nuestra app
        setContent {
            WorkClassTheme {
                ComposeMultiScreenApp(startDestination = destination)

            }
        }
    }


}

@Composable
fun ComposeMultiScreenApp(startDestination: String?) {
    val navController = rememberNavController()
    SetupNavGraph(navController, startDestination ?: "main_menu")
}


@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("main_menu") { MainMenuScreen(navController) } //Se importa la clase
        composable("home_screen") { HomeScreen(navController) }
        composable("test_screen") { TestScreen(navController) }
        composable("interface_screen") { InterfaceLiverpool(navController) }
        composable("components_screen") { ComponentScreen(navController) }
        composable("login_screen") { LoginScreen(navController) }
        composable("accounts_screen") { AccountsScreen(navController) }
        composable("manage_account_screen") { ManageAccountScreen(navController) }
        composable(
            route = "manage_account_screen/{id}",
            arguments = listOf(navArgument("id") { defaultValue = -1 })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
            ManageAccountScreen(
                navController = navController,
                accountId = id
            )
        }
        composable("favorite_accounts_screen") { FavoriteAccountsScreen(navController) }
        composable("camera_screen") { CameraScreen(navController) }
        composable("app_screen") { AppScreen(navController) }
        composable("notification_screen") { NotificationScreen(navController) }
        composable("biometric_screen"){
            val context = LocalContext.current
            BiometricScreen(navController, onAuthSuccess = {
                Toast.makeText(context, "Authentication successful", Toast.LENGTH_SHORT).show()
            })
        }




    }

}