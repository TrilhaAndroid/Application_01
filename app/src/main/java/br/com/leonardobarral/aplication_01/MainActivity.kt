package br.com.leonardobarral.aplication_01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.aplication_01.ui.theme.Aplication_01Theme
import kotlin.math.max

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aplication_01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MeuComponente()
                }
            }
        }
    }
}

@Composable
fun MeuComponente() {

    var idade = remember {
        mutableStateOf(0)
    }
    var status = remember {
        mutableStateOf("")
    }

    Column (
        modifier= Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text(
            text = "Qual sua idade",
            color = Color.Red,
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Pressione os botões para informar a sua idade",
            fontSize = 18.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "${idade.value}",
            fontSize = 48.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(25.dp))

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()

            ){
            Button(
                modifier = Modifier.size(84.dp),
                onClick = {
                    if(idade.value > 0 ){
                        idade.value--
                        if(idade.value >=18){
                            status.value = "Você é Maior de Idade"
                        }else if(idade.value> 0){
                            status.value = "Você é Menor de Idade"
                        }else{
                            status.value = ""
                        }
                    }

                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(if(idade.value == 0) 0xFF434B46 else 0xff10522E )),
                shape = RectangleShape
            ){
                Text(
                    text = "-",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                    )
            }

            Spacer(modifier = Modifier.width(50.dp))

            Button(
                modifier = Modifier.size(84.dp),
                onClick = {
                    if(idade.value < 130 ){
                        idade.value++
                        if(idade.value >=18){
                            status.value = "Você é Maior de Idade"
                        }else if(idade.value> 0){
                            status.value = "Você é Menor de Idade"
                        }else{
                            status.value = ""
                        }
                    }
                },



                colors = ButtonDefaults.buttonColors(containerColor = Color(if(idade.value == 130) 0xFF434B46 else 0xff10522E )),
                shape = RectangleShape
            ) {
                Text(
                    text = "+",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                    )

            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "${status.value}",
            color = Color.Red,
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
        )
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview() {
    MeuComponente()
}
