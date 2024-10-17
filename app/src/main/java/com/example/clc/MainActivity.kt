package com.example.clc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clc.ui.theme.ColumnsELazyColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var tema = mutableIntStateOf(0) // 0 -dark, 1 - light, 2 - alternativo

        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                Principal(tema)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrincipalPreview() {
    val tema = remember { mutableIntStateOf(1) }
    Principal(tema = tema)
}

@Composable
fun Principal(tema: MutableIntState) {
    ColumnsELazyColumnsTheme(tema) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = destinoFormulario.rota
            ) {
                composable(destinoFormulario.rota) {
                    Formulario(navController)
                }
                composable(destinoConfiguracoes.rota) {
                    Configuracoes(tema, navController)
                }
            }
        }
    }
}

@Composable
fun Formulario(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Nome: ")
            OutlinedTextField(value = "", onValueChange = {})
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("E-mail: ")
            OutlinedTextField(value = "", onValueChange = {})
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Telefone: ")
            OutlinedTextField(value = "", onValueChange = {})
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {}) {
                Text("Gravar")
            }
            Button(onClick = {}) {
                Text("Pesquisar")
            }
            Button(onClick = { navController.navigate(destinoConfiguracoes.rota) }) {
                Text("Configurações")
            }
        }
    }
}


@Composable
fun Configuracoes(tema: MutableIntState, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { tema.intValue = 0 }) {
            Text("Paleta Dark")
        }
        Button(onClick = { tema.intValue = 1 }) {
            Text("Paleta Light")
        }
        Button(onClick = { tema.intValue = 2 }) {
            Text("Paleta Alternativa")
        }
        Button(onClick = { navController.navigate(destinoFormulario.rota) }) {
            Text("Ir para o Formulário")
        }
    }
}