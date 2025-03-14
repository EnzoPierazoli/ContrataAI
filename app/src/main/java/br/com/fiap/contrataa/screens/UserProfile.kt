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
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import br.com.fiap.contrataa.R
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme

@Composable
fun UserProfile() {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Top,
		modifier = Modifier
			.fillMaxSize()
			.background(Color(0xFF6141AC))
			.padding(16.dp)
	) {
		Box(
			modifier = Modifier
				.size(120.dp)
				.clip(CircleShape)
				.background(Color.White),
			contentAlignment = Alignment.Center
		) {
			Image(
				painter = painterResource(id = R.drawable.perfil),
				contentDescription = "Foto de perfil",
				modifier = Modifier.fillMaxSize()
			)
		}

		Spacer(modifier = Modifier.height(24.dp))

		// Nome e e-mail
		Text(
			text = "José Carlos",
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			color = Color.White
		)

		Text(
			text = "josecarlos.nunes@email.com",
			fontSize = 14.sp,
			color = Color.Gray
		)

		Spacer(modifier = Modifier.height(24.dp))

		
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp),
			shape = RoundedCornerShape(12.dp),
			colors = CardDefaults.cardColors(containerColor = Color(0xFF91BBB0))
		) {
			Column(
				modifier = Modifier.padding(16.dp),
				horizontalAlignment = Alignment.Start
			) {
				Text(
					text = "Informações do Profissional",
					fontSize = 18.sp,
					fontWeight = FontWeight.Bold,
					color = Color.White
				)
				Spacer(modifier = Modifier.height(16.dp))
				Text(text = "Especialidade: Eletricista", fontSize = 14.sp, color = Color.White)
				Text(text = "Experiência: 5 anos", fontSize = 14.sp, color = Color.White)
				Text(text = "Certificações: NR-10, NR-35", fontSize = 14.sp, color = Color.White)

				Spacer(modifier = Modifier.height(8.dp))


				Row(verticalAlignment = Alignment.CenterVertically) {
					Text(text = "Avaliações:", fontSize = 14.sp, color = Color.White)
					Spacer(modifier = Modifier.width(8.dp))
					repeat(4) {
						Icon(
							imageVector = Icons.Filled.Star,
							contentDescription = "Estrela",
							tint = Color.Yellow,
							modifier = Modifier.size(18.dp)
						)
					}
					Icon(
						imageVector = Icons.Filled.Star,
						contentDescription = "Estrela vazia",
						tint = Color.Gray,
						modifier = Modifier.size(18.dp)
					)
				}
			}
		}

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
				horizontalAlignment = Alignment.Start
			) {
				Text(
					text = "Histórico de Serviços",
					fontSize = 18.sp,
					fontWeight = FontWeight.Bold,
					color = Color.White
				)
				Spacer(modifier = Modifier.height(16.dp))
				Text(
					text = "Instalação Elétrica - 12/03/2025",
					fontSize = 14.sp,
					color = Color.White
				)
				Spacer(modifier = Modifier.height(8.dp))
				Button(
					onClick = { /* Ação para ver detalhes */ },
					colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91BBB0))
				) {
					Text("Ver Detalhes", color = Color.White)
				}
			}
		}

		Spacer(modifier = Modifier.height(24.dp))

		// Botões de Ação
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Button(
				onClick = { /* Ação para agendar serviço */ },
				colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91BBB0)),
				modifier = Modifier
					.fillMaxWidth(0.8f)
					.height(50.dp),
				shape = RoundedCornerShape(10.dp)
			) {
				Text("Agendar Serviço", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
			}

			Spacer(modifier = Modifier.height(16.dp))

			Button(
				onClick = { /* Ação para sair */ },
				colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
				modifier = Modifier
					.fillMaxWidth(0.8f)
					.height(50.dp),
				shape = RoundedCornerShape(10.dp)
			) {
				Text("Sair", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
			}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfilePreview() {
	FiapContrataaTheme {
		UserProfile()
	}
}
