package br.com.fiap.contrataa.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme


// O que seria necessario adicioar
// Nome, email, celular, idade, foto de perfil pais de origem, cidade atual, habilidades, idiomas falado, deficiencias (opicional)
@Composable
fun UserProfile() {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Top,
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black)
			.padding(16.dp)
	) {
		// Foto de perfil (simulada)
		Box(
			modifier = Modifier
				.size(100.dp)
				.clip(CircleShape)
				.background(Color(0xFF6200EE)), // Roxo
			contentAlignment = Alignment.Center
		) {
			Text(
				text = "J",
				fontSize = 40.sp,
				fontWeight = FontWeight.Bold,
				color = Color.White
			)
		}

		Spacer(modifier = Modifier.height(16.dp))


		Text(
			text = "Juliana Nunes",
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			color = Color.White
		)


		Text(
			text = "juliana.nunes@email.com",
			fontSize = 14.sp,
			color = Color.Gray
		)

		Spacer(modifier = Modifier.height(24.dp))


		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp),
			shape = RoundedCornerShape(12.dp),
			colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
		) {
			Column(
				modifier = Modifier.padding(16.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(
					text = "Informações do Perfil",
					fontSize = 18.sp,
					fontWeight = FontWeight.Bold,
					color = Color.White
				)
				Spacer(modifier = Modifier.height(8.dp))
				Text(
					text = "Cargo: Desenvolvedora Júnior",
					fontSize = 14.sp,
					color = Color.White
				)
				Text(
					text = "Empresa: Della Volpe",
					fontSize = 14.sp,
					color = Color.White
				)
			}
		}

		Spacer(modifier = Modifier.height(16.dp))

		// Botões de ação
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Button(
				onClick = { /* Ação de editar perfil */ },
				colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)), // Roxo
				modifier = Modifier.fillMaxWidth()
			) {
				Text("Editar Perfil", color = Color.White)
			}

			Spacer(modifier = Modifier.height(8.dp))

			Button(
				onClick = { /* Ação de logout */ },
				colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
				modifier = Modifier.fillMaxWidth()
			) {
				Text("Sair", color = Color.White)
			}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun UserProfilePreview() {
	FiapContrataaTheme {
		UserProfile()
	}
}
