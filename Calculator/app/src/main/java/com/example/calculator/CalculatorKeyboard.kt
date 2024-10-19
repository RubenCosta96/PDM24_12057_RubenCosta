package com.example.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CreateButton(text: String, onClick: () -> Unit, color: Color) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(55.dp)
            .width(70.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = text)
    }
}

@Composable
fun CalculatorKeyboard() {
    Row {
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "MRC", color = Color.Black, onClick = {})
            CreateButton(text = "√", color = Color.Black, onClick = {})
            CreateButton(text = "7", color = Color.Gray, onClick = {})
            CreateButton(text = "4", color = Color.Gray, onClick = {})
            CreateButton(text = "1", color = Color.Gray, onClick = {})
            CreateButton(text = "0", color = Color.Gray, onClick = {})
        }
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "M-", color = Color.Black, onClick = {})
            CreateButton(text = "%", color = Color.Black, onClick = {})
            CreateButton(text = "8", color = Color.Gray, onClick = {})
            CreateButton(text = "5", color = Color.Gray, onClick = {})
            CreateButton(text = "2", color = Color.Gray, onClick = {})
            CreateButton(text = ".", color = Color.Gray, onClick = {})
        }
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "M+", color = Color.Black, onClick = {})
            CreateButton(text = "+/-", color = Color.Black, onClick = {})
            CreateButton(text = "9", color = Color.Gray, onClick = {})
            CreateButton(text = "6", color = Color.Gray, onClick = {})
            CreateButton(text = "3", color = Color.Gray, onClick = {})
            CreateButton(text = "=", color = Color.Gray, onClick = {})
        }
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CreateButton(text = "ON/C", color = Color.Gray, onClick = {})
            CreateButton(text = "CE", color = Color.Gray, onClick = {})
            CreateButton(text = "÷", color = Color.Black, onClick = {})
            CreateButton(text = "x", color = Color.Black, onClick = {})
            CreateButton(text = "-", color = Color.Black, onClick = {})
            CreateButton(text = "+", color = Color.Black, onClick = {})
        }
    }
}

