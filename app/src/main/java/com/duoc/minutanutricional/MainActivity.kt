package com.duoc.minutanutricional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.duoc.minutanutricional.navigation.MinutaNutricionalNavGraph
import com.duoc.minutanutricional.ui.theme.MinutaNutricionalTheme

/**
 * Punto de entrada de la aplicación.
 *
 * onCreate() es el punto de entrada de la Activity (equivalente a main() en
 * un programa Kotlin tradicional) y, mediante setContent(), define la UI
 * con funciones @Composable que integran los componentes de Material Design
 * y Jetpack Compose que solicita la actividad.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinutaNutricionalTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MinutaNutricionalNavGraph()
                }
            }
        }
    }
}
