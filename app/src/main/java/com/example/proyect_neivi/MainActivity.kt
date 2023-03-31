package com.example.proyect_neivi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyect_neivi.ui.theme.Proyect_NeiviTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyect_NeiviTheme {
                // A surface container using the 'background' color from the theme
                LoginForm(onLoginClicked = { email, password ->
                })
            }
        }
    }
}

@Composable
fun LoginForm(onLoginClicked: (String, String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(

                painter = painterResource(R.drawable.neivi),
                contentDescription = "Imagen de inicio de sesión",
                modifier = Modifier.padding(26.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                colors = TextFieldDefaults.textFieldColors(
                    //backgroundColor = Color.Gray,
                    focusedIndicatorColor = colorResource(id = R.color.btn),
                    unfocusedIndicatorColor = colorResource(id = R.color.btn),
                    textColor = Color.White,
                    cursorColor = colorResource(id = R.color.btn),
                    //activeColor = Color.White,
                ),
                shape = RoundedCornerShape(3.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.padding(16.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                colors = TextFieldDefaults.textFieldColors(
                    //backgroundColor = Color.Gray,
                    focusedIndicatorColor = colorResource(id = R.color.btn),
                    unfocusedIndicatorColor = colorResource(id = R.color.btn),
                    textColor = Color.White,
                    cursorColor = colorResource(id = R.color.btn),
                ),
                shape = RoundedCornerShape(3.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = { onLoginClicked(email, password) },
                modifier = Modifier
                    .padding(26.dp)
                    .height(54.dp)
                    .width(180.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.btn), contentColor = Color.White)
            ) {
                Text(text = "Iniciar sesión")
            }
            }
        }
    }