package com.cypher.forfuckssake

import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.google.android.material.snackbar.Snackbar
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cypher.forfuckssake.Wordle.WordleBox
import com.cypher.forfuckssake.ui.theme.ForfuckssakeTheme
import androidx.core.view.isVisible
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.management.ManagementException
import com.auth0.android.management.UsersAPIClient
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.provider.WebAuthProvider.login
import com.auth0.android.provider.WebAuthProvider.logout
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.cypher.forfuckssake.Wordle.WordleViewModel
import com.google.android.gms.auth.api.credentials.Credential

class MainActivity : ComponentActivity() {
    private var cachedCredentials : Credentials? = null
    private var cachedUserProfile : UserProfile? = null
    private var bool : Boolean = false

    private lateinit var account : Auth0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        account = Auth0(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )
        setContent {
            val context = LocalContext.current
            val scaffold = rememberScaffoldState()

            Scaffold(
                scaffoldState  = scaffold
            )
            {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.initial_title),
                        fontSize = 26.sp,
                    )
                    TextButton(onClick = { login() }) {
                        Text(
                            text = stringResource(R.string.button_login)
                        )
                    }
                    TextButton(onClick = { logout() }) {
                        Text(
                            text = stringResource(R.string.button_logout)
                        )
                    }
                    MyText(isVisible = bool)


                }
            }
        }
    }
    @Composable
    fun MyText(isVisible: Boolean){
        if(isVisible){
            Text(text = stringResource(id = R.string.login_success_message))
        }
    }
    private fun login(
    ) {
        WebAuthProvider
            .login(account)
            .withScheme(getString(R.string.com_auth0_scheme))
            .withScope(getString(R.string.login_scopes))
            .withAudience(getString(R.string.login_audience, getString(R.string.com_auth0_domain)))
            .start(this, object : Callback<Credentials, AuthenticationException> {
                override fun onFailure(exception: AuthenticationException) {
                   Log.e("MainActivity","There is a mistale", exception)

                }

                override fun onSuccess(credentials: Credentials) {
                    cachedCredentials = credentials
                    Log.e("MainActivity","There is a mistale ${credentials}")
                    bool = true
                    showUserProfile()
                }
            })
    }


    private fun logout() {
        WebAuthProvider
            .logout(account)
            .withScheme(getString(R.string.com_auth0_scheme))
            .start(this, object : Callback<Void?, AuthenticationException> {
                override fun onFailure(exception: AuthenticationException) {

                    Log.e("MainActivity","There is a mistale", exception)
                }

                override fun onSuccess(payload: Void?) {
                    cachedCredentials = null
                    cachedUserProfile = null

                }
            })
    }

    fun showUserProfile() {
        if(cachedCredentials == null) {
            return
        }

        val client = AuthenticationAPIClient(account)
        client
            .userInfo(cachedCredentials!!.accessToken!!)
            .start(object : Callback<UserProfile, AuthenticationException> {
                override fun onFailure(error: AuthenticationException) {
                    Log.e("MainActivity","There is a mistale", error)
                }

                override fun onSuccess(result: UserProfile) {
                    cachedUserProfile = result

                }
            })
    }

    private fun getUserMetadata() {
        // Guard against getting the metadata when no user is logged in
        if (cachedCredentials == null) {
            return
        }

        val usersClient = UsersAPIClient(account, cachedCredentials!!.accessToken!!)

        usersClient
            .getProfile(cachedUserProfile!!.getId()!!)
            .start(object : Callback<UserProfile, ManagementException> {

                override fun onFailure(exception: ManagementException) {
                    Log.e("MainActivity","There is a mistale", exception)
                }

                override fun onSuccess(userProfile: UserProfile) {
                    cachedUserProfile = userProfile


                    val country = userProfile.getUserMetadata()["country"] as String?

                }

            })
    }


}

