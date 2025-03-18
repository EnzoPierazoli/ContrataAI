import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    AppScaffold(title = "login") {
        LoginForm(navController)
    }
}

@Composable
private fun LoginForm(navController: NavHostController) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.BackgroundRoxo))
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(240.dp)
                .padding(bottom = 24.dp)
                .offset(y = (-60).dp)
                .background(colorResource(id = R.color.BackgroundRoxo))
        )

        Text(
            text = stringResource(R.string.slogan),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.CorDoTexto),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .offset(y = (-60).dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(R.string.first_TextField), fontSize = 14.sp) },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions.Default,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(56.dp)
                .offset(y = (-50).dp)

        )

        Spacer(modifier = Modifier.height(5.dp))


        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.second_TextField), fontSize = 14.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(56.dp)
                .offset(y = (-45).dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                navController.navigate("accessOrder")
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .offset(y = (-20).dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.CorDoBotao),
                contentColor = Color.Black,
            )
        ) {
            Text(
                fontSize = 16.sp,
                text = (stringResource(R.string.button_text_login)),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = (stringResource(R.string.string_underbutton)),
            fontSize = 16.sp,
            color = colorResource(id = R.color.CorDoTexto),
            textAlign = TextAlign.Center,
        )
        Text(
            text = (stringResource(R.string.clique_aqui)),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            color = colorResource(id = R.color.CorDoTexto),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("cadastro")
                }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    FiapContrataaTheme {
        LoginScreen(rememberNavController())
    }
}


