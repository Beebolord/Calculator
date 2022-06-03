package com.cypher.forfuckssake

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LoginScreen(
    onLogin : ()-> Unit,
    onLogOut : ()->Unit,
) {
   Column(
       modifier = Modifier.fillMaxSize()
   ) {
       Button(
            onClick = {
                onLogin()
            }
        )
       {

       }
   }
}