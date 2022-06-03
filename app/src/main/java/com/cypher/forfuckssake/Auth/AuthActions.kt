package com.cypher.login.Auth

sealed class AuthActions {
    object Login : AuthActions()
    object Logout : AuthActions()
    object ShowUserProfile : AuthActions()
    object GetUserMetadata : AuthActions()
}
