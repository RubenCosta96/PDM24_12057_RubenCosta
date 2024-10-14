    package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Column {
                calculatorScreen()
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun createButton(text: String, onClick: () -> Unit, color: Color){
    Button(onClick = onClick,
        modifier = Modifier.height(60.dp).width(80.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)) {
        Text(text = text)
    }
}

@Composable
fun calculatorScreen(){
    Column{
        var result = "0"
        Text(result,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun calculatorKeyboard() {
    Row{
        Column{
            createButton(text = "MRC", color = Color.Black, onClick = {})
            createButton(text = "√", color = Color.Black, onClick = {})
            createButton(text = "7", color = Color.Gray, onClick = {})
            createButton(text= "4", color = Color.Gray, onClick = {})
            createButton(text= "1", color = Color.Gray, onClick = {})
            createButton(text= "0", color = Color.Gray, onClick = {})
        }
        Column{
            createButton(text="M-", color = Color.Black, onClick = {})
            createButton(text="%", color = Color.Black, onClick = {})
            createButton(text= "8", color = Color.Gray, onClick = {})
            createButton(text="5", color = Color.Gray, onClick = {})
            createButton(text="2", color = Color.Gray, onClick = {})
            createButton(text= ".", color = Color.Gray, onClick = {})
        }
        Column{
            createButton(text="M+", color = Color.Black, onClick = {})
            createButton(text= "+/-", color = Color.Black, onClick = {})
            createButton(text="9", color = Color.Gray, onClick = {})
            createButton(text="6", color = Color.Gray, onClick = {})
            createButton(text="3", color = Color.Gray, onClick = {})
            createButton(text="=", color = Color.Gray, onClick = {})
        }
        Column{
            createButton(text="ON/C", color = Color.Gray, onClick = {})
            createButton(text="CE", color = Color.Gray, onClick = {})
            createButton(text="÷", color = Color.Black, onClick = {})
            createButton(text="x", color = Color.Black, onClick = {})
            createButton(text="-", color = Color.Black, onClick = {})
            createButton(text="+", color = Color.Black, onClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Column {
            calculatorScreen()
            calculatorKeyboard()
        }

    }
}