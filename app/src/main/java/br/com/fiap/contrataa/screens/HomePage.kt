package br.com.fiap.contrataa.screens

import androidx.compose.material.icons.filled.Home
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Person


// Definição de cores
val DarkPurple = Color(0xFF57449a)
val LightPurple = Color(0xFF7B1FA2)
val BackgroundColor = DarkPurple
val Button = Color.White

@Composable
fun HomePage() {
    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() },
        ) { innerPadding ->
            MainContent(Modifier.padding(innerPadding))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = { Text("Boas-Vindas", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = DarkPurple)
    )
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("O que você precisa?", fontSize = 20.sp, color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Button)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Assistência Técnica", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkPurple)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = DarkPurple)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Button)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Reformas e Reparos", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkPurple)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = DarkPurple)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Button)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Serviços Domésticos", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkPurple)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = DarkPurple)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Button)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Aulas Particulares", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkPurple)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = DarkPurple)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Button)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Eventos", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkPurple)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = DarkPurple)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text("Mais Serviços", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        RepairServices()
    }
}

@Composable
fun RepairServices() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf("Serviços Elétricos", "Marido de Aluguel", "Mudanças e Carretos").forEach { service ->
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Box(modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(service, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkPurple)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomePage() {
    HomePage()
}