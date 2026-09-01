package com.duoc.minutanutricional.model

// clase de datos (data class) que representa a un usuario registrado.
// Kotlin genera automaticamente equals(), hashCode() y toString() para esta clase
data class Usuario(
    val nombre: String,
    val email: String,
    val password: String
)
