package br.com.fiap.contrataa.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.contrataa.R
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme

@Composable
fun UserProfile(onBackClick: () -> Unit, navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6141AC))
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Voltar",
                tint = Color.White
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
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

                    InfoCard(
                        title = "Informações Pessoais",
                        content = listOf(
                            "Idade: 37 anos",
                            "Sexo: Masculino",
                            "Pais Origem: África",
                            "Cidade Atual: Santo André - SP",
                            "Serviços Contratados: 3",
                            "Deficiência: Nanismo",
                        ),
                        navController = navController
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    InfoCard(
                        title = "Histórico de Serviços",
                        content = listOf(
                            "Eletricista - 12/09/2024",
                            "Jardineiro - 10/06/2024",
                            "Diarista - 08/05/2024",
                        ),
                        showButton = true,
                        navController = navController
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { navController.navigate("login")},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            "Sair",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }

    }
}
@Composable
fun InfoCard(title: String, content: List<String>, showButton: Boolean = false, navController: NavHostController) {
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
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            content.forEach {
                Text(text = it, fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (showButton) {
                Button(
                    onClick = {navController.navigate("accessOrder")},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91BBB0))
                ) {
                    Text("Ver Detalhes", color = Color.White)
                }
            }
        }
    }
}



@Composable
fun UserProfileScreen(navController: NavHostController) {
        UserProfile(onBackClick = { navController.popBackStack() }, navController,)
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfilePreview() {
    val navController = rememberNavController()
    FiapContrataaTheme {
        UserProfileScreen(navController = navController)
    }
}
