package br.com.fiap.contrataa.screens

import br.com.fiap.contrataa.R
import androidx.compose.material.icons.filled.Home
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

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
        title = { Text(text = stringResource(id = R.string.boas_vindas), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.CorDoTexto)) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = colorResource(id = R.color.BackgroundRoxo)),
    )
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.BackgroundRoxo))
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        var searchText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text(stringResource(R.string.placeholder1), fontSize = 20.sp, color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White, // Define a cor do texto quando o campo está focado
                unfocusedTextColor = Color.White, // Define a
            )
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(stringResource(R.string.assistencia_tecnica), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = colorResource(id = R.color.BackgroundRoxo))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(stringResource(R.string.reformas_reparos), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = colorResource(id = R.color.BackgroundRoxo))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(stringResource(R.string.servicos_domesticos), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = colorResource(id = R.color.BackgroundRoxo))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(stringResource(R.string.servicos_eletricos), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = colorResource(id = R.color.BackgroundRoxo))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(stringResource(R.string.mudancas_carretos), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Ir", tint = colorResource(id = R.color.BackgroundRoxo))
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(stringResource(R.string.mais_servicos), fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        MoreServices()
    }
}

@Composable
fun MoreServices() {
    NavigationBar(
        modifier = Modifier.height (95.dp),
        containerColor = colorResource(id = R.color.BackgroundRoxo)
    ) {
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Aulas", tint = Color.White) },
            label = { Text(stringResource(R.string.aulas), color = Color.White) },
            selected = false,
            onClick = { /* TODO */ }
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Eventos", tint = Color.White) },
            label = { Text(stringResource(R.string.eventos), color = Color.White) },
            selected = false,
            onClick = { /* TODO */ }
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Marcenaria", tint = Color.White) },
            label = { Text(stringResource(R.string.marcenaria), color = Color.White) },
            selected = false,
            onClick = { /* TODO */ }
        )
    }
}

@Composable
fun BottomBar() {
    NavigationBar(
        modifier = Modifier.height (85.dp),
        containerColor = colorResource(id = R.color.BackgroundRoxo)
    ) {
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.White) },
            label = { Text(stringResource(R.string.inicio), color = Color.White) },
            selected = true,
            onClick = { /* TODO */ }
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Pedidos", tint = Color.White) },
            label = { Text(stringResource(R.string.pedidos), color = Color.White) },
            selected = false,
            onClick = { /* TODO */ }
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.Person , contentDescription = "Perfil", tint = Color.White) },
            label = { Text(stringResource(R.string.perfil), color = Color.White) },
            selected = false,
            onClick = { /* TODO */ }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomePage() {
    HomePage()
}