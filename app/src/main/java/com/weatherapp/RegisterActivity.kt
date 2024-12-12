package com.weatherapp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var nome by rememberSaveable{ mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordEqual by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Crie sua conta no WeatherApp",
            fontSize = 24.sp
        )

        Spacer(modifier = modifier.size(24.dp))

        OutlinedTextField(
            value = nome,
            label = { Text(text = "Digite seu nome") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { nome = it }
        )

        Spacer(modifier = modifier.size(24.dp))

        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu e-mail") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { email = it }
        )

        Spacer(modifier = modifier.size(24.dp))

        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = modifier.size(24.dp))

        OutlinedTextField(
            value = passwordEqual,
            label = { Text(text = "Repita sua senha") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { passwordEqual = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = modifier.size(24.dp))

        Row(modifier = modifier) {
            Button(
                onClick = {
                    Toast.makeText(activity, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()

                    activity?.finish()

                    nome= ""; email= ""; password= ""; passwordEqual= ""
                },
                enabled = nome.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordEqual.isNotEmpty()
                        && password == passwordEqual
            ){
                Text("Registrar")
            }

            Spacer(modifier = modifier.size(24.dp))

            Button(
                onClick = {nome= ""; email= ""; password= ""; passwordEqual= ""},
                enabled = nome.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordEqual.isNotEmpty()

            ){
                Text("Limpar")
            }
        }

    }
}