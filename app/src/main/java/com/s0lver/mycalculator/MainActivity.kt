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
import androidx.compose.foundation.layout.fillMaxWidth
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

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {
                        Text("Result is: ", modifier = Modifier.align(Alignment.CenterVertically))
                        Text(result.toString())
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    var numberOnScreen by remember { mutableStateOf("0") }
                    var currentState by remember { mutableStateOf(CalculatorState.NUMBER) }
                    var currentOperator: CalculatorOperator? by remember { mutableStateOf(null) }

                    var currentNumber: Double = 0.0


                    Text("Calculator v2")
                    Text(numberOnScreen)


                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "7")
                        }) { Text("7") }
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "8")
                        }) { Text("8") }
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "9")
                        }) { Text("9") }
                        Button(onClick = {
                            currentOperator = CalculatorOperator.PLUS
                            currentState = CalculatorState.OPERATOR

                            if (numberOnScreen.isNotEmpty() && numberOnScreen.last() != '.') {
                                currentNumber = numberOnScreen.toDouble()
                                numberOnScreen = ""
                            }
                        }) { Text("+") }
                    }

                    Row {
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "4")
                        }) { Text("4") }
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "5")
                        }) { Text("5") }
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "6")
                        }) { Text("6") }
                        Button(onClick = {
                            currentOperator = CalculatorOperator.MINUS
                            currentState = CalculatorState.OPERATOR
                        }) { Text("-") }
                    }

                    Row {
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "1")
                        }) { Text("1") }
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "2")
                        }) { Text("2") }
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "3")
                        }) { Text("3") }
                        Button(onClick = {
                            currentOperator = CalculatorOperator.MULTIPLY
                            currentState = CalculatorState.OPERATOR
                        }) { Text("*") }
                    }

                    Row {
                        Button(onClick = {
                            numberOnScreen = appendNumber(numberOnScreen, "0")
                        }) { Text("0") }
                        Button(onClick = {
                            if (!numberOnScreen.contains(".")) {
                                numberOnScreen += "."
                            }
                        }) { Text(".") }
                        Button(onClick = {}) { Text("=") }
                        Button(onClick = {
                            currentOperator = CalculatorOperator.DIVIDE
                            currentState = CalculatorState.OPERATOR
                        }) { Text("/") }
                    }

                    Row {
                        Text("Current operator $currentOperator")
                    }
                }
            }
        }
    }
}

enum class CalculatorState {
    NUMBER,
    OPERATOR
}

enum class CalculatorOperator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE
}

fun appendNumber(currentNumber: String, newNumber: String): String {
    if (currentNumber == "0") {
        return newNumber
    }
    return currentNumber + newNumber
}
