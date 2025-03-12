package br.com.fiap.contrataa

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme
import br.com.fiap.contrataa.ui.theme.UserProfile

class MainActivity : ComponentActivity() {
	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			FiapContrataaTheme {
				val navController = rememberNavController()

				Scaffold (
					modifier = Modifier.fillMaxSize(),
				) {
					NavHost(navController, startDestination = "login") {
						composable("login") { LoginScreen(navController) }
						composable("cadastro") { CadastroScreen() }
						composable("perfil") { UserProfile() }
					}
				}
			}
		}
	}
}

@Composable
private fun AppScaffold(
	title: String,
	content: @Composable () -> Unit
) {
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Header(title)
		Box(
			modifier = Modifier
				.weight(1f)
				.fillMaxWidth()
				.padding(vertical = 16.dp),
			contentAlignment = Alignment.Center
		) {
			content()
		}
		Footer()
	}
}

@Composable
private fun Header(title: String) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(60.dp)
			.background(Color(0xFF57449a)),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = title,
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			color = Color.White
		)
	}
}

@Composable
private fun Footer() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(40.dp)
			.background(Color.Gray),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = "ContrataAí",
			fontSize = 12.sp,
			color = Color.White
		)
	}
}

@Composable
private fun LoginScreen(navController: androidx.navigation.NavHostController) {
	AppScaffold(title = "Login") {
		LoginForm(navController)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginForm(navController: androidx.navigation.NavHostController) {
	var username by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = Modifier
			.fillMaxWidth()
			.padding(36.dp)
	) {
		Text(
			text = "Faça seu Login",
			fontSize = 24.sp,
			textAlign = TextAlign.Center,
			modifier = Modifier.padding(bottom = 16.dp)
		)

		TextField(
			value = username,
			onValueChange = { username = it },
			label = { Text("Usuário") },
			modifier = Modifier.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(8.dp))

		TextField(
			value = password,
			onValueChange = { password = it },
			label = { Text("Senha") },
			visualTransformation = PasswordVisualTransformation(),
			modifier = Modifier.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(16.dp))

		Button(
			onClick = {
				// validar usuario e sennha

				navController.navigate("perfil") 

		    },
			shape = RoundedCornerShape(8.dp)
		) {
			Text("Entrar")
		}

		Spacer(modifier = Modifier.height(16.dp))

		Text(
			text = "Não possui cadastro ainda?\nClique AQUI",
			fontSize = 16.sp,
			textDecoration = TextDecoration.Underline,
			color = MaterialTheme.colorScheme.primary,
			modifier = Modifier.clickable {
				navController.navigate("cadastro")
			}
		)
	}
}

@Composable
fun CadastroScreen() {
	AppScaffold(title = "Cadastro") {
		Text("Tela de Cadastro", fontSize = 24.sp, textAlign = TextAlign.Center)
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
	FiapContrataaTheme {
		LoginScreen(rememberNavController())
	}
}


