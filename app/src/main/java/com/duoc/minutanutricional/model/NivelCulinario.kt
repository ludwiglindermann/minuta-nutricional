package com.duoc.minutanutricional.model

// enum class: un tipo de clase especial para representar un conjunto fijo y
// conocido de opciones. Cada constante (PRINCIPIANTE, INTERMEDIO, AVANZADO)
// es un objeto de esta clase, creado con el constructor que recibe "etiqueta"
enum class NivelCulinario(val etiqueta: String) {
    PRINCIPIANTE("Principiante"),
    INTERMEDIO("Intermedio"),
    AVANZADO("Avanzado")
}
