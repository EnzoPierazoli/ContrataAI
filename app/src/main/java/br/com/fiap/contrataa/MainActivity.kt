package br.com.fiap.contrataa

import AccessOrder
import CadastroScreen
import LoginScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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

                val currentRoute by navController.currentBackStackEntryFlow.collectAsState(initial = navController.currentBackStackEntry)

                val hideBottomBarRoutes = listOf("login", "cadastro")

                Scaffold(
                    bottomBar = {
                        if (currentRoute?.destination?.route !in hideBottomBarRoutes) {
                            BottomBar(navController)
                        }
                    },
                    modifier = Modifier.background(colorResource(id = R.color.BackgroundRoxo))
                ) {
                    NavHost(navController, startDestination = "login", modifier = Modifier.fillMaxSize()) {
                        composable("login") { LoginScreen(navController) }
                        composable("cadastro") { CadastroScreen(navController, onBackClick = { navController.popBackStack() }) }
                        composable("homepage") { HomePage(navController) }
                        composable("perfil") { UserProfile(onBackClick = { navController.popBackStack() }, navController) }
                        composable("accessOrder") { AccessOrder(onBackClick = { navController.popBackStack() }, navController) }
                    }
                }
            }
        }
    }
}



@Composable
fun BottomBar(navController: NavHostController) {
    // Obtém a rota atual para definir qual item está selecionado
    val currentRoute by navController.currentBackStackEntryFlow.collectAsState(initial = navController.currentBackStackEntry)

    NavigationBar(
        modifier = Modifier.height(85.dp),
        containerColor = colorResource(id = R.color.BackgroundRoxo)
    ) {
        NavigationBarItem(
            modifier = Modifier.height(56.dp),
            icon = { Icon(Icons.Default.Home, contentDescription = "Início", tint = Color.White) },
            label = { Text(stringResource(R.string.inicio), color = Color.White) },
            selected = currentRoute?.destination?.route == "homepage",
            onClick = { navController.navigate("homepage") }
        )
        NavigationBarItem(
            modifier = Modifier.height(56.dp),
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Serviços", tint = Color.White) },
            label = { Text(stringResource(R.string.servicos), color = Color.White) },
            selected = currentRoute?.destination?.route == "accessOrder",
            onClick = { navController.navigate("accessOrder") }
        )
        NavigationBarItem(
            modifier = Modifier.height(56.dp),
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White) },
            label = { Text(stringResource(R.string.perfil), color = Color.White) },
            selected = currentRoute?.destination?.route == "perfil",
            onClick = { navController.navigate("perfil") }
        )
    }
}

