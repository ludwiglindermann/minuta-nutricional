package com.duoc.minutanutricional.model

// otro enum class, esta vez con un companion object: un objeto asociado a la
// clase (no a cada instancia) que sirve para agrupar funciones relacionadas,
// como esta que calcula el nivel calorico correspondiente a una receta
enum class NivelCalorico(val etiqueta: String) {
    LIGERA("Ligera"),
    MODERADA("Moderada"),
    ALTA("Alta en calorías");

    companion object {
        // when con rangos (in): elige la constante segun el rango de calorias
        fun desde(calorias: Int): NivelCalorico = when (calorias) {
            in 0..349 -> LIGERA
            in 350..449 -> MODERADA
            else -> ALTA
        }
    }
}
