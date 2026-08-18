package com.duoc.minutanutricional.navigation

/**
 * Rutas de navegación de la aplicación.
 * Se centralizan aquí para evitar strings "mágicos" repetidos en cada pantalla.
 */
object Rutas {
    const val LOGIN = "login"
    const val REGISTRO = "registro"
    const val RECUPERAR = "recuperar"
    const val MINUTA = "minuta"

    const val DETALLE_RECETA = "detalleReceta"
    const val DETALLE_RECETA_ARG = "recetaId"
    const val DETALLE_RECETA_RUTA = "$DETALLE_RECETA/{$DETALLE_RECETA_ARG}"

    fun detalleRecetaConId(id: Int) = "$DETALLE_RECETA/$id"
}
