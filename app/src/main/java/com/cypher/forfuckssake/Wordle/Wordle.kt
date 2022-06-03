package com.cypher.forfuckssake.Wordle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.auth0.android.Auth0
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.cypher.forfuckssake.CalculatorViewModel
/*
@Composable
fun Wordle(
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonSpacing = 8.dp

    var first by remember { mutableStateOf("") }
    var second by remember { mutableStateOf("") }
    var third by remember { mutableStateOf("") }
    var fourth by remember { mutableStateOf("") }
    var fifth by remember { mutableStateOf("") }

    var value1 by remember { mutableStateOf("E") }
    val viewModel2 = viewModel<WordleViewModel>()
    viewModel2.setWord("banana")
)
{ Scaffold(
modifier = Modifier.fillMaxSize()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        viewModel2.state.finalWord?.let { it1 ->
            Text(
                text = it1
            )
        }
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),

        ) {

        viewModel2.state.firstLetter?.letter?.let { it1 ->
            TextField(
                value = it1,
                onValueChange = { viewModel2.setFirstLetter(it1) },
                maxLines = 1,
                textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii,
                    capitalization = KeyboardCapitalization.Characters,
                    imeAction = ImeAction.Next
                )
            )
        }

        TextField(
            value = second,
            onValueChange = { second = it },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = third,
            onValueChange = { third = it },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = fourth,
            onValueChange = { fourth = it },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = fourth,
            onValueChange = { fourth = it },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = fifth,
            onValueChange = { fifth = it },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next
            )
        )

    }

}
/*
    Calculator(
state = state,
onAction = viewModel::onAction,
buttonSpacing = buttonSpacing,
modifier = Modifier
.fillMaxSize()
.background(Color.DarkGray)
)
*/
*/