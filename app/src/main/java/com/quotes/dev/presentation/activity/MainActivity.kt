package com.quotes.dev.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quotes.dev.R
import com.quotes.dev.presentation.theme.QuoteOfTheDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteOfTheDayTheme {
        var textState by remember {
            mutableStateOf(TextFieldState(""))
            // TODO: z mainviewmodel
        }
        var dropDownMenuExpanded by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Image(
                painterResource(R.drawable.ic_main),
                contentDescription = "Quotes of the day icon",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally)
                    .alpha(0.6f)
            )
            Column(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .background(Color.Magenta)
                    .fillMaxWidth(0.8f)
                    .heightIn(min = 50.dp, max = 300.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                BasicTextField(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .align(Alignment.Start),
                    state = textState,
                    textStyle = LocalTextStyle.current,
                    lineLimits = TextFieldLineLimits.Default
                    // TODO: line limit
                )
                BasicTextField(
                    modifier = Modifier
                        .background(Color.Red)
                        .align(Alignment.End),
                    state = textState,
                    textStyle = LocalTextStyle.current,
                    lineLimits = TextFieldLineLimits.Default
                    // TODO: line limit
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 100.dp)
                    .background(Color.Magenta)
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight()
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.Bottom),
                    colors = ButtonColors(
                        containerColor = Color.Red,
                        contentColor = Color.Blue,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.LightGray
                    ),
                    onClick = {
                        // TODO: event on click
                    }
                ) {
                    Text("Losuj")
                    // TODO: strings resources
                }
                ExposedDropdownMenuBox(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth(1f)
                        .heightIn(50.dp)
                        .align(Alignment.Bottom),
                    expanded = dropDownMenuExpanded,
                    onExpandedChange = {
                        dropDownMenuExpanded = !dropDownMenuExpanded
                    }
                ) {
                    MaterialTheme(
                        shapes = MaterialTheme.shapes.copy(
                            extraSmall = RoundedCornerShape(8.dp),
                            small = RoundedCornerShape(8.dp),
                            medium = RoundedCornerShape(8.dp),
                            large = RoundedCornerShape(8.dp),
                            extraLarge = RoundedCornerShape(8.dp)
                        )
                    ) {
                        TextField(
                            value = "textState",
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropDownMenuExpanded) },
                            modifier = Modifier
                                .background(shape = RoundedCornerShape(8.dp), color = Color.Cyan)
                                .menuAnchor()
                        )
                        DropdownMenu(
                            expanded = dropDownMenuExpanded,
                            onDismissRequest = {
                                dropDownMenuExpanded = false
                            }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Item no 1") },
                                onClick = {}
                            )
                            DropdownMenuItem(
                                text = { Text("Item no 2") },
                                onClick = {}
                            )
                        }
                    }

                }

            }
        }
    }
}