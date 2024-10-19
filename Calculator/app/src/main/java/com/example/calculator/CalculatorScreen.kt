package com.example.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen() {
    var result by remember { mutableStateOf("0") }
    var currentNumber by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf<String?>(null) }
    var previousNumber by remember { mutableStateOf("") }

    val onNumberClick = { number: String ->
        if (number == ".") {
            if (!currentNumber.contains(".")) {
                currentNumber += number
            }
        } else {
            if (currentNumber == "0") {
                currentNumber = number
            } else {
                currentNumber += number
            }
        }
        result = currentNumber
    }

    val onClearClick = {
        currentNumber = "0"
        result = "0"
        previousNumber = ""
        operator = null
    }

    val onEqualClick = {
        if (operator != null && previousNumber.isNotEmpty() && currentNumber.isNotEmpty()) {
            val num1 = previousNumber.toDoubleOrNull()
            val num2 = currentNumber.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                if (operator == "+") {
                    result = (num1 + num2).toString()
                } else if (operator == "-") {
                    result = (num1 - num2).toString()
                } else if (operator == "x") {
                    result = (num1 * num2).toString()
                } else if (operator == "÷") {
                    if (num2 != 0.0) {
                        result = (num1 / num2).toString()
                    } else {
                        result = "Erro"
                    }
                }
            } else {
                result = "Erro"
            }
            previousNumber = ""
            currentNumber = result
            operator = null
        }
    }

    val onOperatorClick = { selectedOperator: String ->
        if (currentNumber.isNotEmpty()) {
            if (previousNumber.isNotEmpty()) {
                onEqualClick()
            }
            previousNumber = currentNumber
            currentNumber = ""
            operator = selectedOperator
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Text(
            text = result,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(20.dp))
        CalculatorKeyboard(
            onNumberClick = onNumberClick,
            onClearClick = onClearClick,
            onOperatorClick = onOperatorClick,
            onEqualClick = onEqualClick
        )
    }
}