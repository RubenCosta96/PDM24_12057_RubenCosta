package com.example.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//@Composable
//fun CreateButton(text: String, onClick: () -> Unit, color: Color) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier
//            .height(55.dp)
//            .width(70.dp),
//        shape = RoundedCornerShape(20.dp),
//        colors = ButtonDefaults.buttonColors(containerColor = color)
//    ) {
//        Text(text = text)
//    }
//}

@Composable
fun CreateButton(text: String, onClick: () -> Unit, color: Color) {
    Box(modifier = Modifier.padding(4.dp)) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(90.dp),
            shape = CircleShape,
            containerColor = color,
            contentColor = Color.White
        ) {
            Text(text = text)
        }
    }
}

@Composable
fun CalculatorKeyboard(
    onNumberClick: (String) -> Unit,
    onClearClick: () -> Unit,
    onOperatorClick: (String) -> Unit,
    onEqualClick: () -> Unit
) {
    LazyVerticalGrid(columns = GridCells.Fixed(4)) { }

    Row {
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "MRC", color = Color.Black, onClick = {})
            CreateButton(text = "√", color = Color.Black, onClick = {})
            CreateButton(text = "7", color = Color.Gray, onClick = { onNumberClick("7") })
            CreateButton(text = "4", color = Color.Gray, onClick = { onNumberClick("4") })
            CreateButton(text = "1", color = Color.Gray, onClick = { onNumberClick("1") })
            CreateButton(text = "0", color = Color.Gray, onClick = { onNumberClick("0") })
        }
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "M-", color = Color.Black, onClick = {})
            CreateButton(text = "%", color = Color.Black, onClick = {})
            CreateButton(text = "8", color = Color.Gray, onClick = { onNumberClick("8") })
            CreateButton(text = "5", color = Color.Gray, onClick = { onNumberClick("5") })
            CreateButton(text = "2", color = Color.Gray, onClick = { onNumberClick("2") })
            CreateButton(text = ".", color = Color.Gray, onClick = { onNumberClick(".") })
        }
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "M+", color = Color.Black, onClick = {})
            CreateButton(text = "+/-", color = Color.Black, onClick = {})
            CreateButton(text = "9", color = Color.Gray, onClick = { onNumberClick("9") })
            CreateButton(text = "6", color = Color.Gray, onClick = { onNumberClick("6") })
            CreateButton(text = "3", color = Color.Gray, onClick = { onNumberClick("3") })
            CreateButton(text = "=", color = Color.Gray, onClick = onEqualClick)
        }
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "ON/C", color = Color.Gray, onClick = onClearClick)
            CreateButton(text = "CE", color = Color.Gray, onClick = {})
            CreateButton(text = "÷", color = Color.Black, onClick = { onOperatorClick("÷") })
            CreateButton(text = "x", color = Color.Black, onClick = { onOperatorClick("x") })
            CreateButton(text = "-", color = Color.Black, onClick = { onOperatorClick("-") })
            CreateButton(text = "+", color = Color.Black, onClick = { onOperatorClick("+") })
        }
    }
}

