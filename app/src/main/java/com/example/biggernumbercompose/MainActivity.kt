package com.example.biggernumbercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiggerNumber()

        }
    }
}

var random: Int = Random.nextInt(1, 1000)


@Composable
fun BiggerNumber() {
    var textnumber by remember { mutableStateOf("") }
    var hint by remember { mutableStateOf("Please enter your Number :") }
    var points by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),) {
        Text(
            text = "Number guessing game", fontSize = 26.sp,color = Color.Magenta, textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth().background(color = Color.Black)
        )
        Spacer(modifier = Modifier.padding(top = 75.dp))
        Text(
            text = "$hint", fontSize = 18.sp, textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
        )
        Row(

            horizontalArrangement = Arrangement.Center

        )
        {
            TextField(
                value = textnumber,
                onValueChange = {
                    textnumber = it
                },
                modifier = Modifier
                    .alignByBaseline()
                    .padding(start = 40.dp)
            )
            Button(
                modifier = Modifier
                    .alignByBaseline()
                    .padding(10.dp),
                onClick = {
                    val number: Int = textnumber.toString().toInt()

                    if (number < random) {
                        points++
                        hint = "Wrong, your number is lower"

                    } else if (number > random) {
                        points++
                        hint = "Wrong, your number is higher"

                    } else {

                        hint = "It's Correct! you win!"

                    }
                    textnumber = ""

                }

            ) {
                Text(text = stringResource(id = R.string.check))
            }

        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Guessing Number : $points",
            textAlign = TextAlign.Center,

            )
        Button(
            modifier = Modifier
                .padding(10.dp),
            onClick = {
                random = Random.nextInt(1, 1000)
                hint = "Please enter your guess:"
                points = 0
            })
        {
            Text(text = stringResource(id = R.string.reset))
        }
    }

}
@Composable
fun Showmage(){

}

