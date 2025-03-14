import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.contrataa.R
import br.com.fiap.contrataa.ui.theme.FiapContrataaTheme

@Composable
private fun AppScaffold(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Header(title)
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
//        Footer()
    }
}

// Footer e Header caso precise

//@Composable
//private fun Header(title: String) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//            .background(colorResource(id = R.color.BackgroundRoxo)),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = title,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            color = colorResource(id = R.color.CorDoTexto)
//        )
//    }
//}
//
//@Composable
//private fun Footer() {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(40.dp)
//            .background(colorResource(id = R.color.BackgroundRoxo)),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "ContrataAí",
//            fontSize = 12.sp,
//            color = colorResource(id = R.color.CorDoTexto)
//        )
//    }
//}

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
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.BackgroundRoxo)),
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo",
            modifier = Modifier
                .size(240.dp)
                .padding(bottom = 24.dp)
                .background(colorResource(id = R.color.BackgroundRoxo))
        )
        Text(
            text = "Crie sua Conta",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.CorDoTexto),
            modifier = Modifier.padding(bottom = 64.dp)
        )


        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nome de Usuário", fontSize = 14.sp) },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(32.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Email", fontSize = 14.sp) },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(32.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha", fontSize = 14.sp) },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(32.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirme sua Senha", fontSize = 14.sp) },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(32.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate("perfil")
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(120.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = (colorResource(id = R.color.CorDoBotao)),
                contentColor = Color.Black
                )
        ) {
            Text(
                text = "Cadastrar",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CadastroScreenPreview() {
    FiapContrataaTheme {
        CadastroScreen(rememberNavController())
    }
}
