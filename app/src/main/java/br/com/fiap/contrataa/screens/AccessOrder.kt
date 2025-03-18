import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.contrataa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessOrder(onBackClick: () -> Unit, navController: NavHostController) {
    val pedidos = listOf(
        Pedido("02 de Abril de 2025", "Pintor", "Agendado"),
        Pedido("20 de Abril de 2025", "Encanador", "Agendado"),
        Pedido("12 de Setembro de 2024", "Eletricista", "Já Realizado"),
        Pedido("10 de Junho de 2024", "Jardineiro", "Já Realizado"),
        Pedido("08 de Maio de 2024", "Diarista", "Já Realizado"),
    )

    val emAndamento = pedidos.filter { it.status == "Agendado" }
    val jaRealizados = pedidos.filter { it.status == "Já Realizado" }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Meus Serviços",
                        fontSize = 30.sp,
                        color = colorResource(id = R.color.CorDoTexto),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6141AC))
            )
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF6141AC))
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (emAndamento.isNotEmpty()) {
                    item {
                        SectionTitle(title = "Serviços em Andamento")
                    }
                    items(emAndamento) { pedido ->
                        PedidoItem(pedido.date, pedido.title, pedido.status) { }
                    }
                }
                if (jaRealizados.isNotEmpty()) {
                    item {
                        SectionTitle(title = "Serviços Já Realizados")
                    }
                    items(jaRealizados) { pedido ->
                        PedidoItem(pedido.date, pedido.title, pedido.status) { }
                    }
                }
            }
        }
    }
}



@Composable
fun PedidoIconeComBorda(
    imageVector: ImageVector,
    contentDescription: String,
    borderColor: Color
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(50.dp)
            .border(2.dp, borderColor, CircleShape)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = borderColor,
            modifier = Modifier.size(30.dp)
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        PedidoIconeComBorda(
            imageVector = Icons.Filled.Build,
            contentDescription = "Serviços Agendados",
            borderColor = Color(0xFFFFA500)
        )

        PedidoIconeComBorda(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "Serviço realizado",
            borderColor = Color(0xFF4CAF50)
        )
    }

}

data class Pedido(val date: String, val title: String, val status: String)

@Composable
fun PedidoItem(date: String, title: String, status: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
            .border(
                width = 5.dp,
                color = if (status == "Agendado") Color(0xFFFF9800) else Color(0xFF4CAF50),
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = date,
                fontSize = 12.sp,
                color = Color.DarkGray
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Detalhes",
                    tint = Color(0xFF6141AC),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = status,
                fontSize = 14.sp,
                color = if (status == "Agendado") Color(0xFFFF9800) else Color(0xFF4CAF50),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 16.dp)
    )
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
            selected = false,
            onClick = {
                navController.navigate("homepage")
            },
        )
        NavigationBarItem(
            modifier = Modifier.height (56.dp),
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Serviços", tint = Color.White) },
            label = { Text(stringResource(R.string.servicos), color = Color.White) },
            selected = true,
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

// Preview
@Preview(showBackground = true)
@Composable
fun AccessOrderPreview() {
    AccessOrder(onBackClick = {},navController = rememberNavController())
}