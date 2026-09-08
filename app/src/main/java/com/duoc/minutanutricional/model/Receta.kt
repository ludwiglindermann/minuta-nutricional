package com.duoc.minutanutricional.model

// modelo de datos que representa una receta dentro de la minuta semanal.
// data class: Kotlin genera solo equals(), hashCode() y toString().
// Implementa Recomendable, la interfaz que obliga a entregar una
// recomendacionNutricional, tal como pide la actividad de esta semana
data class Receta(
    val id: Int,
    val dia: String,
    val nombre: String,
    val descripcion: String,
    val emoji: String,
    val tiempoPreparacionMinutos: Int,
    val porciones: Int,
    val calorias: Int,
    val proteinasGramos: Int,
    val carbohidratosGramos: Int,
    val grasasGramos: Int,
    val ingredientes: List<String>,
    val preparacion: List<String>,
    override val recomendacionNutricional: String
) : Recomendable
