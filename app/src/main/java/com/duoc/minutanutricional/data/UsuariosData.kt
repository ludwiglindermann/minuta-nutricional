package com.duoc.minutanutricional.data

import com.duoc.minutanutricional.model.Usuario

// fuente de datos de los usuarios de la app.
// Se guardan primero en un array (tipo de dato basico de Kotlin), tal como
// se hizo con las recetas, y luego se convierten a una lista mutable para
// poder agregar nuevos usuarios desde la pantalla de Registro
object UsuariosData {

    // private: solo se puede usar dentro de este archivo/objeto. Es el
    // modificador de visibilidad mas restrictivo de Kotlin
    private val usuariosBase: Array<Usuario> = arrayOf(
        Usuario(nombre = "Javiera Muñoz", email = "javiera.munoz@gmail.com", password = "Javi2024"),
        Usuario(nombre = "Benjamín Rojas", email = "benjamin.rojas@gmail.com", password = "Rojas123"),
        Usuario(nombre = "Camila Torres", email = "camila.torres@gmail.com", password = "Camila99"),
        Usuario(nombre = "Matías Soto", email = "matias.soto@gmail.com", password = "Soto2024"),
        Usuario(nombre = "Valentina Pérez", email = "valentina.perez@gmail.com", password = "Valen456")
    )

    // toMutableList() convierte el array de partida en una MutableList, una
    // coleccion de Kotlin que sí permite agregar elementos en tiempo de ejecucion
    val usuarios: MutableList<Usuario> = usuariosBase.toMutableList()

    // any {} es una funcion de coleccion: revisa si al menos un elemento
    // cumple la condicion del bloque lambda, sin necesidad de escribir un bucle
    fun existeCorreo(email: String): Boolean =
        usuarios.any { it.email.equals(email, ignoreCase = true) }

    fun validar(email: String, password: String): Boolean =
        usuarios.any { it.email.equals(email, ignoreCase = true) && it.password == password }

    fun registrar(usuario: Usuario) {
        usuarios.add(usuario)
    }
}
