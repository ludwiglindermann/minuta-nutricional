package com.duoc.minutanutricional.util

// funcion de extension: agrega un comportamiento nuevo a un tipo que ya existe
// (String) sin tener que heredar de el ni modificarlo. Se llama igual que
// cualquier metodo: "miTexto.tieneAlMenosUnDigito()"
fun String.tieneAlMenosUnDigito(): Boolean = any { it.isDigit() }
