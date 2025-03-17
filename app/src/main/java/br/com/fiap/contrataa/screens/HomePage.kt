package br.com.fiap.contrataa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Definição de cores para o tema preto e roxo
val DarkPurple = Color(0xFF4A148C)
val LightPurple = Color(0xFF7B1FA2)
val BackgroundColor = Color.Black
val TextColor = Color.White


@Composable
fun HomePage() {
    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() },
            bottomBar = { BottomBar() }
        ) { innerPadding ->
            MainContent(Modifier.padding(innerPadding))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = { Text("CONTRATA.AI", color = TextColor) },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Person, contentDescription = "Perfil", tint = TextColor)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = DarkPurple)
    )
}

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = DarkPurple
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar", tint = TextColor) },
            label = { Text("Buscar", color = TextColor) },
            selected = false,
            onClick = { /* TODO */ }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "Carrinho",
                    tint = TextColor
                )
            },
            label = { Text("Carrinho", color = TextColor) },
            selected = false,
            onClick = { /* TODO */ }
        )
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Mais de 500 tipos de serviços em um só lugar",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Encontre profissionais e contrate serviços para tudo o que precisar",
            color = TextColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        var searchText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("O que você precisa?", color = TextColor) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = LightPurple)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White, // Define a cor do texto quando o campo está focado
                cursorColor = TextColor,
                disabledBorderColor = DarkPurple
            )
        )


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(containerColor = LightPurple)
        ) {
            Text("Explorar serviços", color = TextColor)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de serviços populares
        Text("Populares:", fontWeight = FontWeight.Bold, color = TextColor)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf(
                "Diarista",
                "Marido de aluguel",
                "Pintor",
                "Adestrador",
                "Encanador"
            ).forEach {
                Chip(it)
            }
        }
    }
}

@Composable
fun Chip(text: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = LightPurple),
        modifier = Modifier.clickable { /* TODO */ }
    ) {
        Text(text, modifier = Modifier.padding(8.dp), color = TextColor)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainContent() {
    HomePage()
}
