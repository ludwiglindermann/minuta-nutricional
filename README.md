# Minuta Nutricional

App para las actividades formativas de DSY2204: "Integrando los componentes básicos de una aplicación móvil" (Semana 1), "Explorando Kotlin para el desarrollo de una aplicación móvil" (Semana 3) e "Integrando funcionalidades básicas a una aplicación móvil con Kotlin" (Semana 4).

## Descripción

App Android (Kotlin + Jetpack Compose + Material 3) para visualizar una minuta nutricional semanal: 5 recetas (una por día, de lunes a viernes) con su información nutricional, ingredientes y preparación.

## Qué tiene

- Login validado contra un arreglo de usuarios (correo y contraseña reales, no solo campos no vacíos).
- Registro con inputs, combo box, radio buttons y checklist. Valida correo duplicado y que la contraseña tenga al menos un número (con una función de extensión); al registrarse, el usuario queda disponible de inmediato para iniciar sesión.
- Recuperar contraseña (simulado, no envía correo real).
- Minuta semanal: grilla con las 5 recetas, más el total y promedio de calorías de la semana (con funciones de colección) y una etiqueta de nivel calórico por receta (enum class).
- Detalle de receta: ingredientes, preparación y una tabla (armada con un Map) con información nutricional.

## Captura del flujo

_(pendiente: agregar captura de Login → Minuta → Detalle)_

## Usuarios de prueba

javiera.munoz@gmail.com / Javi2024
benjamin.rojas@gmail.com / Rojas123
camila.torres@gmail.com / Camila99
matias.soto@gmail.com / Soto2024
valentina.perez@gmail.com / Valen456

## Estructura del proyecto

```
app/src/main/java/com/duoc/minutanutricional/
├── MainActivity.kt
├── model/
│   ├── Receta.kt                # implementa la interfaz Recomendable
│   ├── Recomendable.kt          # interfaz
│   ├── Usuario.kt
│   ├── NivelCulinario.kt        # enum class
│   └── NivelCalorico.kt         # enum class con companion object
├── data/
│   ├── RecetasData.kt           # array con las 5 recetas semanales
│   └── UsuariosData.kt          # array/lista con los usuarios registrados
├── util/
│   └── Validaciones.kt          # funcion de extension sobre String
├── navigation/
│   ├── Rutas.kt
│   └── NavGraph.kt
└── ui/
    ├── components/CampoTexto.kt
    ├── screens/
    │   ├── LoginScreen.kt
    │   ├── RegistroScreen.kt
    │   ├── RecuperarPasswordScreen.kt
    │   ├── MinutaScreen.kt
    │   └── RecetaDetalleScreen.kt
    └── theme/ (Color.kt, Type.kt, Theme.kt)
```

## Cómo abrir y ejecutar el proyecto

1. Abre **Android Studio** (versión Koala o superior recomendado).
2. `File > Open...` y selecciona la carpeta raíz de este proyecto.
3. Espera a que Android Studio sincronice Gradle. **Nota:** el archivo `gradle/wrapper/gradle-wrapper.jar` no viene incluido (se generó este proyecto en un entorno sin acceso a los servidores de Gradle/Google); Android Studio lo descargará automáticamente al sincronizar, siempre que tengas conexión a internet. Si te pide reparar el wrapper, acepta.
4. Ejecuta la app en un emulador o dispositivo físico con **Android 7.0 (API 24)** o superior.

## Requisitos técnicos usados

- Kotlin 1.9.24
- Android Gradle Plugin 8.5.2 / Gradle 8.7
- Jetpack Compose (BOM 2024.06.00) + Material 3
- Navigation Compose 2.7.7
- compileSdk / targetSdk 34, minSdk 24

## Autor

Ludwig Lindermann — Ingeniería en Desarrollo de Software, Duoc UC.
