# Minuta Nutricional

Proyecto de la actividad formativa **"Integrando los componentes básicos de una aplicación móvil"** — Semana 1, Desarrollo de Aplicaciones Móviles (DSY2204), Duoc UC.

## Descripción

Aplicación móvil Android (Kotlin + Jetpack Compose + Material Design 3) que permite a una dueña de casa con baja habilidad informática visualizar una **minuta nutricional semanal**: 5 recetas (una por día, de lunes a viernes) con su información nutricional, ingredientes y preparación.

## Características implementadas

- **Login**: inicio de sesión con validación básica de campos (input, botón, vínculos a Registro y Recuperar contraseña).
- **Registro de usuario**: formulario con inputs, un combo box (número de integrantes del hogar), radio buttons (nivel de experiencia en la cocina) y una checklist de selección múltiple (preferencias alimentarias).
- **Recuperar contraseña**: solicitud de recuperación por correo electrónico.
- **Minuta semanal**: grilla (`LazyVerticalGrid`) con las 5 recetas de la semana, almacenadas en un `Array<Receta>` (`RecetasData.kt`).
- **Detalle de receta**: ingredientes, preparación paso a paso y una tabla con la información nutricional (calorías, proteínas, carbohidratos, grasas) y una recomendación nutricional.
- Navegación entre pantallas con **Navigation Compose**.

## Estructura del proyecto

```
app/src/main/java/com/duoc/minutanutricional/
├── MainActivity.kt
├── model/Receta.kt
├── data/RecetasData.kt          # array con las 5 recetas semanales
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
