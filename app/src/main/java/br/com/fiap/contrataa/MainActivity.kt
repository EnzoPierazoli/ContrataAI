package br.com.fiap.contrataa

import AccessOrder
import CadastroScreen
import LoginScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.contrataa.screens.HomePage
import br.com.fiap.contrataa.screens.UserProfile
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapContrataaTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavHost(navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("cadastro") {
                            CadastroScreen(
                                navController,
                                onBackClick = { navController.popBackStack() })
                        }
                        composable("homepage") { HomePage() }
                        composable("perfil") { UserProfile(onBackClick = { navController.popBackStack() }) }
                        composable("accessOrder") { AccessOrder(onBackClick = { navController.popBackStack() }) }
                    }
                }
            }
        }
    }
}



