package com.example.absenkuy.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.absenkuy.data.local.UserPreferences
import com.example.absenkuy.ui.home.HomeScreen
import com.example.absenkuy.ui.izin.IzinScreen
import com.example.absenkuy.ui.login.LoginScreen
import com.example.absenkuy.ui.mk.MKScreen
import kotlinx.coroutines.flow.Flow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val userPreferences = UserPreferences.getInstance(applicationContext)


        setContent {
            AbsenKuyApp(userPreferences.isUserLoggedIn())
        }
    }
}


@Composable
fun AbsenKuyApp(isUserLoggedInFlow: Flow<Boolean>) {
    val navController = rememberNavController()
    val isUserLoggedIn = isUserLoggedInFlow.collectAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()


    NavHost(
        navController = navController,
        startDestination = if (isUserLoggedIn.value) "home" else "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("matkul") {
            MKScreen(navController = navController)
        }
        composable("izin") {
            IzinScreen(navController = navController)
        }
    }
}



