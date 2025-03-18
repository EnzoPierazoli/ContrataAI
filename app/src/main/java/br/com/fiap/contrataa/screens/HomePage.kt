package br.com.fiap.contrataa.screens

import br.com.fiap.contrataa.R
import androidx.compose.material.icons.filled.Home
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = R.string.boas_vindas), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.CorDoTexto)) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = colorResource(id = R.color.BackgroundRoxo)),
    )
}

@Composable
fun HomePage(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        // Passa o padding interno para o MainContent
        MainContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val services = listOf(
        stringResource(R.string.assistencia_tecnica),
        stringResource(R.string.reformas_reparos),
        stringResource(R.string.servicos_domesticos),
        stringResource(R.string.servicos_eletricos),
        stringResource(R.string.mudancas_carretos)
    )

    val moreServices = listOf(
        Pair(Icons.Default.AddCircle, stringResource(R.string.aulas)),
        Pair(Icons.Default.AddCircle, stringResource(R.string.eventos)),
        Pair(Icons.Default.AddCircle, stringResource(R.string.marcenaria))
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.BackgroundRoxo))
            .padding(16.dp)
    ) {
        item {
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
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
        }

        items(services) { service ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(service, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Ir", tint = colorResource(id = R.color.BackgroundRoxo))
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Text(stringResource(R.string.mais_servicos), fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
        }

        items(moreServices) { (icon, label) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.CorDoBotao))
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(icon, contentDescription = label, tint = colorResource(id = R.color.BackgroundRoxo))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = label, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.BackgroundRoxo))
                }
            }
        }
    }
}

@Composable
private fun BottomBar(navController: NavHostController) {
    NavigationBar(
        modifier = Modifier.height (85.dp),
        containerColor = colorResource(id = R.color.BackgroundRoxo)
    ) {
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.White) },
            label = { Text(stringResource(R.string.inicio), color = Color.White) },
            selected = true,
            onClick = {
                navController.navigate("homepage")
            },
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Serviços", tint = Color.White) },
            label = { Text(stringResource(R.string.servicos), color = Color.White) },
            selected = false,
            onClick = {
                navController.navigate("accessOrder")
            },
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.Person , contentDescription = "Perfil", tint = Color.White) },
            label = { Text(stringResource(R.string.perfil), color = Color.White) },
            selected = false,
            onClick = {
                navController.navigate("perfil")
            },
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomePage() {
    HomePage(navController = rememberNavController())
}