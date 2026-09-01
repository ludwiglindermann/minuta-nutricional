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

// punto de entrada de la aplicacion. onCreate() cumple el mismo rol que
// main() en un programa Kotlin tradicional, y aca solo se delega la UI
// al NavGraph mediante setContent()
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
