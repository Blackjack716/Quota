package com.quotes.dev.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quotes.dev.R
import com.quotes.dev.presentation.theme.CategoryMenuTheme
import com.quotes.dev.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun QuoteHomeScreen(innerPadding: PaddingValues = PaddingValues(20.dp)) {

    val contentWidthFraction = 0.8f

    val quoteTextStyle by remember {
        mutableStateOf(TextFieldState("testowy quote"))
        // TODO: z mainviewmodel
    }
    val authorNameState by remember {
        mutableStateOf(TextFieldState("testowy author name"))
        // TODO: z mainviewmodel
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        Image(
            painterResource(R.drawable.ic_main),
            contentDescription = "Quotes of the day icon",
            modifier = Modifier
                .padding(top = 2.dp)
                .height(180.dp)
                .align(Alignment.CenterHorizontally)
                .alpha(0.6f)
        )
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(contentWidthFraction)
                .requiredHeightIn(min = 200.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            BasicTextField(
                modifier = Modifier
                    .padding(4.dp)
                    .border(BorderStroke(2.dp, color = Color.LightGray), shape = RoundedCornerShape(8.dp))
                    .align(Alignment.Start),
                state = quoteTextStyle,
                textStyle = LocalTextStyle.current.copy(fontStyle = FontStyle.Italic),
                lineLimits = TextFieldLineLimits.Default
                // TODO: line limit
            )
            BasicTextField(
                modifier = Modifier
                    .padding(4.dp)
                    .border(BorderStroke(2.dp, color = Color.LightGray), shape = RoundedCornerShape(8.dp))
                    .align(Alignment.End),
                state = authorNameState,
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End, fontStyle = FontStyle.Italic),
                lineLimits = TextFieldLineLimits.SingleLine,
                // TODO: line limit
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(contentWidthFraction)
                .align(Alignment.CenterHorizontally)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxHeight()
            ) {
                GenerateQuoteButton()
                CategoryDropdownMenu()
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropdownMenu() {

    val categoryData = listOf("all", "philosophy", "ancient", "humor", "other", "cat1", "cat2", "cat3", "cat4")

    var isDropDownMenuExpanded by remember { mutableStateOf(false) }

    var currentCategory by remember { mutableStateOf(categoryData.first()) }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .padding(end = 8.dp),
        expanded = isDropDownMenuExpanded,
        onExpandedChange = {
            isDropDownMenuExpanded = !isDropDownMenuExpanded
        }
    ) {
        CategoryMenuTheme {
            OutlinedTextField(
                label = { Text(stringResource(R.string.menu_hint)) },
                value = currentCategory,
                onValueChange = {

                },
                textStyle = Typography.bodyMedium,
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropDownMenuExpanded) },
                modifier = Modifier
                    .menuAnchor()
                    .clip(RoundedCornerShape(8.dp))
                    .height(54.dp)
            )
            val scrollState = rememberScrollState()
            ExposedDropdownMenu(
                modifier = Modifier
                    .requiredHeightIn(max = 150.dp)
                    .exposedDropdownSize(),
                expanded = isDropDownMenuExpanded,
                onDismissRequest = {
                    isDropDownMenuExpanded = false
                },
                scrollState = scrollState
            ) {
                categoryData.forEach {
                    DropdownMenuItem(
                        modifier = Modifier
                            .fillMaxSize(),
                        text = { Text(it) },
                        onClick = {
                            //view model change category
                            currentCategory = it
                            isDropDownMenuExpanded = false
                        },
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    )
                    HorizontalDivider(thickness = 2.dp, color = Color.DarkGray)
                }
            }
        }

    }
}

@Composable
fun GenerateQuoteButton() {
    Button(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .height(46.dp),
        colors = ButtonColors(
            containerColor = Color.LightGray,
            contentColor = Color.White,
            disabledContainerColor = Color.DarkGray,
            disabledContentColor = Color.LightGray
        ),
        shape = RoundedCornerShape(12.dp),
        onClick = {
            // TODO: event on click
        }
    ) {
        Text(stringResource(R.string.generate_button_text))
    }
}