package br.com.fiap.contrataa

import CadastroScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.contrataa.screens.LoginScreen
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme
import br.com.fiap.contrataa.screens.UserProfile


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
						composable("cadastro") { CadastroScreen(navController) }
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
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black),
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
fun CadastroScreen(navController: NavHostController) {
	AppScaffold(title = "Cadastro") {
		CadastroForm(navController)
	}
}

@Composable
private fun CadastroForm(navController: NavHostController) {
	var username by remember { mutableStateOf("") }
	var email by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var confirmPassword by remember { mutableStateOf("") }

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(8.dp),
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black) // Fundo preto no formulário
			.padding(36.dp)
			.verticalScroll(rememberScrollState())
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_launcher_foreground),
			contentDescription = "Logo",
			modifier = Modifier
				.size(120.dp)
				.padding(bottom = 16.dp)
		)

		Text(
			text = "Crie sua Conta",
			fontSize = 24.sp,
			textAlign = TextAlign.Center,
			color = Color.White, // Texto branco para contraste
			modifier = Modifier.padding(bottom = 16.dp)
		)

		TextField(
			value = username,
			onValueChange = { username = it },
			label = { Text("Nome de Usuário", color = Color.White) },
			modifier = Modifier.fillMaxWidth(),
			colors = TextFieldDefaults.colors(
				unfocusedContainerColor = Color.DarkGray,
				focusedContainerColor = Color.Gray,
				cursorColor = Color.White,
				focusedLabelColor = Color.White
			)
		)

		TextField(
			value = email,
			onValueChange = { email = it },
			label = { Text("E-mail", color = Color.White) },
			modifier = Modifier.fillMaxWidth(),
			colors = TextFieldDefaults.colors(
				unfocusedContainerColor = Color.DarkGray,
				focusedContainerColor = Color.Gray,
				cursorColor = Color.White,
				focusedLabelColor = Color.White
			)
		)

		TextField(
			value = password,
			onValueChange = { password = it },
			label = { Text("Senha", color = Color.White) },
			visualTransformation = PasswordVisualTransformation(),
			modifier = Modifier.fillMaxWidth(),
			colors = TextFieldDefaults.colors(
				unfocusedContainerColor = Color.DarkGray,
				focusedContainerColor = Color.Gray,
				cursorColor = Color.White,
				focusedLabelColor = Color.White
			)
		)

		TextField(
			value = confirmPassword,
			onValueChange = { confirmPassword = it },
			label = { Text("Confirme sua Senha", color = Color.White) },
			visualTransformation = PasswordVisualTransformation(),
			modifier = Modifier.fillMaxWidth(),
			colors = TextFieldDefaults.colors(
				unfocusedContainerColor = Color.DarkGray,
				focusedContainerColor = Color.Gray,
				cursorColor = Color.White,
				focusedLabelColor = Color.White
			)
		)

		Button(
			onClick = {
				navController.navigate("perfil")
			},
			shape = RoundedCornerShape(8.dp),
			modifier = Modifier.fillMaxWidth(),
			colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
		) {
			Text("Cadastrar")
		}

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = "Já tem uma conta?\nClique AQUI para entrar",
			fontSize = 16.sp,
			textDecoration = TextDecoration.Underline,
			color = Color.White,
			textAlign = TextAlign.Center,
			modifier = Modifier
				.fillMaxWidth()
				.clickable {
					navController.navigate("login")
				}
		)
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CadastroScreenPreview() {
	FiapContrataaTheme {
		CadastroScreen(rememberNavController())
	}
}


