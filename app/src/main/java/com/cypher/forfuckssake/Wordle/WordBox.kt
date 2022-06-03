package com.cypher.forfuckssake.Wordle

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cypher.forfuckssake.ui.theme.Shapes

@Composable
fun WordleBox(
    letter : String,
    modifier : Modifier = Modifier,
    onEnter : () -> Unit,
    value : String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(50.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {onEnter})
    }
    }

