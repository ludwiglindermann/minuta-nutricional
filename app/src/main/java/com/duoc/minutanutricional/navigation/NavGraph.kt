package com.duoc.minutanutricional.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.duoc.minutanutricional.ui.screens.LoginScreen
import com.duoc.minutanutricional.ui.screens.MinutaScreen
import com.duoc.minutanutricional.ui.screens.RecetaDetalleScreen
import com.duoc.minutanutricional.ui.screens.RecuperarPasswordScreen
import com.duoc.minutanutricional.ui.screens.RegistroScreen

// grafo de navegacion de la app: conecta Login, Registro, Recuperar contraseña,
// Minuta semanal y Detalle de receta usando Navigation Compose
@Composable
fun MinutaNutricionalNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN
    ) {
        composable(Rutas.LOGIN) {
            LoginScreen(
                onLoginExitoso = {
                    navController.navigate(Rutas.MINUTA) {
                        popUpTo(Rutas.LOGIN) { inclusive = true }
                    }
                },
                onIrARegistro = { navController.navigate(Rutas.REGISTRO) },
                onIrARecuperarPassword = { navController.navigate(Rutas.RECUPERAR) }
            )
        }

        composable(Rutas.REGISTRO) {
            RegistroScreen(
                onRegistroExitoso = {
                    navController.popBackStack(Rutas.LOGIN, inclusive = false)
                },
                onVolverALogin = { navController.popBackStack() }
            )
        }

        composable(Rutas.RECUPERAR) {
            RecuperarPasswordScreen(
                onVolverALogin = { navController.popBackStack() }
            )
        }

        composable(Rutas.MINUTA) {
            MinutaScreen(
                onRecetaSeleccionada = { recetaId ->
                    navController.navigate(Rutas.detalleRecetaConId(recetaId))
                },
                onCerrarSesion = {
                    navController.navigate(Rutas.LOGIN) {
                        popUpTo(Rutas.MINUTA) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = Rutas.DETALLE_RECETA_RUTA,
            arguments = listOf(navArgument(Rutas.DETALLE_RECETA_ARG) { type = NavType.IntType })
        ) { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getInt(Rutas.DETALLE_RECETA_ARG) ?: -1
            RecetaDetalleScreen(
                recetaId = recetaId,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}
