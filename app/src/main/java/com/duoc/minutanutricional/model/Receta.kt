package com.duoc.minutanutricional.model

/**
 * Modelo de datos que representa una receta dentro de la minuta semanal.
 *
 * @param id identificador único de la receta, usado para navegar al detalle.
 * @param dia día de la semana al que corresponde la receta (ej. "Lunes").
 * @param nombre nombre de la receta.
 * @param descripcion breve descripción de la receta.
 * @param emoji representación visual simple de la receta (evita depender de imágenes externas).
 * @param tiempoPreparacionMinutos tiempo estimado de preparación, en minutos.
 * @param porciones cantidad de porciones que rinde la receta.
 * @param calorias calorías totales aproximadas por porción (kcal).
 * @param proteinasGramos proteínas por porción, en gramos.
 * @param carbohidratosGramos carbohidratos por porción, en gramos.
 * @param grasasGramos grasas por porción, en gramos.
 * @param ingredientes lista de ingredientes necesarios.
 * @param preparacion pasos de preparación, en orden.
 * @param recomendacionNutricional consejo nutricional asociado a la receta.
 */
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
    val recomendacionNutricional: String
)
