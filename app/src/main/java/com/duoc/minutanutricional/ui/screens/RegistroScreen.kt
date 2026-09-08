package com.duoc.minutanutricional.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.duoc.minutanutricional.R
import com.duoc.minutanutricional.data.UsuariosData
import com.duoc.minutanutricional.model.NivelCulinario
import com.duoc.minutanutricional.model.Usuario
import com.duoc.minutanutricional.ui.components.CampoTexto
import com.duoc.minutanutricional.util.tieneAlMenosUnDigito
import kotlinx.coroutines.launch

private val opcionesIntegrantesHogar = listOf("1 - 2 personas", "3 - 4 personas", "5 o más personas")
private val opcionesPreferenciasAlimentarias = listOf("Vegetariano", "Vegano", "Sin gluten", "Sin lactosa")

// Vista de Registro de usuario.
//
// Integra los siguientes componentes UI de Material Design / Jetpack Compose,
// tal como lo pide la actividad:
// - inputs (nombre, correo, contraseña, confirmar contraseña)
// - combo box (numero de integrantes del hogar)
// - radio buttons (nivel de experiencia en la cocina)
// - check list (preferencias alimentarias, seleccion multiple)
// - boton y vinculo de vuelta al login
//
// Al registrarse correctamente, el usuario se agrega al arreglo de
// UsuariosData y queda disponible de inmediato para iniciar sesion
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(
    onRegistroExitoso: () -> Unit,
    onVolverALogin: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmarPassword by remember { mutableStateOf("") }

    var integrantesHogarExpandido by remember { mutableStateOf(false) }
    var integrantesHogarSeleccionado by remember { mutableStateOf(opcionesIntegrantesHogar.first()) }

    // NivelCulinario.entries recorre todas las constantes del enum, en el
    // orden en que fueron declaradas
    var nivelCulinarioSeleccionado by remember { mutableStateOf(NivelCulinario.entries.first()) }

    // Set<String>: coleccion que no permite valores repetidos, ideal para una
    // checklist de seleccion multiple donde cada opcion cuenta una sola vez
    val preferenciasSeleccionadas = remember { mutableStateOf(setOf<String>()) }

    var aceptaTerminos by remember { mutableStateOf(false) }
    var mostrarError by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val errorCampos = stringResource(R.string.registro_error_campos)
    val errorPassword = stringResource(R.string.registro_error_password)
    val errorTerminos = stringResource(R.string.registro_error_terminos)
    val errorCorreoExistente = stringResource(R.string.registro_error_correo_existente)
    val errorPasswordSinNumero = stringResource(R.string.registro_error_password_sin_numero)
    val mensajeExito = stringResource(R.string.registro_exito)

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.registro_titulo),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            CampoTexto(
                valor = nombre,
                onValorChange = { nombre = it },
                etiqueta = stringResource(R.string.registro_nombre)
            )

            Spacer(modifier = Modifier.height(16.dp))

            CampoTexto(
                valor = email,
                onValorChange = { email = it },
                etiqueta = stringResource(R.string.registro_email),
                tipoTeclado = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(16.dp))

            CampoTexto(
                valor = password,
                onValorChange = { password = it },
                etiqueta = stringResource(R.string.registro_password),
                esPassword = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            CampoTexto(
                valor = confirmarPassword,
                onValorChange = { confirmarPassword = it },
                etiqueta = stringResource(R.string.registro_confirmar_password),
                esPassword = true,
                esError = mostrarError && confirmarPassword != password,
                mensajeError = if (mostrarError && confirmarPassword != password) errorPassword else null
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Combo box (menú desplegable) - Material3 DropdownMenu
            Text(
                text = stringResource(R.string.registro_integrantes_hogar),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = integrantesHogarSeleccionado,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { integrantesHogarExpandido = true }
                )
                DropdownMenu(
                    expanded = integrantesHogarExpandido,
                    onDismissRequest = { integrantesHogarExpandido = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    opcionesIntegrantesHogar.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                integrantesHogarSeleccionado = opcion
                                integrantesHogarExpandido = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Radio buttons - selección única del nivel de experiencia en la cocina
            Text(
                text = stringResource(R.string.registro_nivel_culinario),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                NivelCulinario.entries.forEach { opcion ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (opcion == nivelCulinarioSeleccionado),
                                onClick = { nivelCulinarioSeleccionado = opcion },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = (opcion == nivelCulinarioSeleccionado),
                            onClick = { nivelCulinarioSeleccionado = opcion }
                        )
                        Text(text = opcion.etiqueta, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Check list - selección múltiple de preferencias alimentarias
            Text(
                text = stringResource(R.string.registro_preferencias),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                opcionesPreferenciasAlimentarias.forEach { opcion ->
                    val marcado = preferenciasSeleccionadas.value.contains(opcion)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Checkbox(
                            checked = marcado,
                            onCheckedChange = { marcarlo ->
                                preferenciasSeleccionadas.value = if (marcarlo) {
                                    preferenciasSeleccionadas.value + opcion
                                } else {
                                    preferenciasSeleccionadas.value - opcion
                                }
                            }
                        )
                        Text(text = opcion, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = aceptaTerminos,
                    onCheckedChange = { aceptaTerminos = it }
                )
                Text(
                    text = stringResource(R.string.registro_terminos),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // tieneAlMenosUnDigito() es la funcion de extension de
                    // util/Validaciones.kt, se usa igual que un metodo de String
                    when {
                        nombre.isBlank() || email.isBlank() || password.isBlank() || confirmarPassword.isBlank() -> {
                            mostrarError = true
                            scope.launch { snackbarHostState.showSnackbar(errorCampos) }
                        }
                        password != confirmarPassword -> {
                            mostrarError = true
                            scope.launch { snackbarHostState.showSnackbar(errorPassword) }
                        }
                        !password.tieneAlMenosUnDigito() -> {
                            mostrarError = true
                            scope.launch { snackbarHostState.showSnackbar(errorPasswordSinNumero) }
                        }
                        UsuariosData.existeCorreo(email) -> {
                            scope.launch { snackbarHostState.showSnackbar(errorCorreoExistente) }
                        }
                        !aceptaTerminos -> {
                            scope.launch { snackbarHostState.showSnackbar(errorTerminos) }
                        }
                        else -> {
                            UsuariosData.registrar(
                                Usuario(nombre = nombre, email = email, password = password)
                            )
                            scope.launch {
                                snackbarHostState.showSnackbar(mensajeExito)
                            }
                            onRegistroExitoso()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = stringResource(R.string.registro_boton))
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = onVolverALogin,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.registro_volver_login))
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
