package com.s0lver.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var number1 by remember { mutableStateOf("0") }
            var number2 by remember { mutableStateOf("0") }

            var result by remember { mutableDoubleStateOf(0.0) }

            Box(
                Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.safeDrawing)
            ) {
                Column {
                    Row {
                        Text(
                            "Input number 1",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        TextField(value = number1, onValueChange = {
                            number1 = it
                        })
                    }

                    Row {
                        Text(
                            "Input number 2",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        TextField(value = number2, onValueChange = {
                            number2 = it
                        })
                    }

                    Row(Modifier.align(Alignment.CenterHorizontally)) {
                        Button(onClick = {
                            val num1 = number1.toDouble()
                            val num2 = number2.toDouble()
                            result = num1 + num2
                        }) {
                            Text("+")
                        }

                        Button(onClick = {
                            val num1 = number1.toDouble()
                            val num2 = number2.toDouble()
                            result = num1 - num2
                        }) {
                            Text("-")
                        }

                        Button(onClick = {
                            val num1 = number1.toDouble()
                            val num2 = number2.toDouble()
                            result = num1 * num2
                        }) {
                            Text("*")
                        }

                        Button(onClick = {
                            val num1 = number1.toDouble()
                            val num2 = number2.toDouble()
                            result = num1 / num2
                        }) {
                            Text("/")
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Row {
                        Text("Result is: ", modifier = Modifier.align(Alignment.CenterVertically))
                        Text(result.toString())
                    }
                }
            }
        }
    }
}