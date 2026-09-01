package com.duoc.minutanutricional.data

import com.duoc.minutanutricional.model.Receta

// fuente de datos de la minuta semanal.
// tal como lo solicita la actividad, los datos de las 5 recetas semanales
// se almacenan en un arreglo (Array<Receta>)
object RecetasData {

    val recetas: Array<Receta> = arrayOf(
        Receta(
            id = 1,
            dia = "Lunes",
            nombre = "Ensalada de quinoa y verduras",
            descripcion = "Una ensalada fresca, liviana y rica en fibra para comenzar la semana.",
            emoji = "🥗",
            tiempoPreparacionMinutos = 25,
            porciones = 2,
            calorias = 320,
            proteinasGramos = 10,
            carbohidratosGramos = 45,
            grasasGramos = 10,
            ingredientes = listOf(
                "1 taza de quinoa cocida",
                "1 tomate en cubos",
                "1/2 pepino en cubos",
                "1/4 de cebolla morada picada",
                "Jugo de 1 limón",
                "2 cucharadas de aceite de oliva",
                "Sal y pimienta a gusto"
            ),
            preparacion = listOf(
                "Cocer la quinoa según las instrucciones del envase y dejar enfriar.",
                "Picar el tomate, el pepino y la cebolla morada.",
                "Mezclar todos los ingredientes en un bol grande.",
                "Aliñar con jugo de limón, aceite de oliva, sal y pimienta.",
                "Servir fría."
            ),
            recomendacionNutricional = "La quinoa es una excelente fuente de proteína vegetal completa, " +
                "ideal para acompañar el almuerzo de inicio de semana."
        ),
        Receta(
            id = 2,
            dia = "Martes",
            nombre = "Pechuga de pollo al horno con arroz integral",
            descripcion = "Un plato equilibrado, alto en proteínas y bajo en grasas saturadas.",
            emoji = "🍗",
            tiempoPreparacionMinutos = 40,
            porciones = 2,
            calorias = 410,
            proteinasGramos = 35,
            carbohidratosGramos = 40,
            grasasGramos = 9,
            ingredientes = listOf(
                "2 pechugas de pollo",
                "1 taza de arroz integral",
                "1 diente de ajo picado",
                "1 cucharada de aceite de oliva",
                "Orégano, sal y pimienta a gusto"
            ),
            preparacion = listOf(
                "Sazonar las pechugas con ajo, orégano, sal y pimienta.",
                "Hornear a 200°C durante 25-30 minutos hasta que estén doradas.",
                "Cocinar el arroz integral según las instrucciones del envase.",
                "Servir el pollo acompañado del arroz integral."
            ),
            recomendacionNutricional = "El pollo horneado (sin freír) reduce el consumo de grasas, " +
                "y el arroz integral aporta más fibra que el arroz blanco."
        ),
        Receta(
            id = 3,
            dia = "Miércoles",
            nombre = "Salmón al vapor con espárragos",
            descripcion = "Rico en Omega-3, ideal para el bienestar cardiovascular.",
            emoji = "🐟",
            tiempoPreparacionMinutos = 30,
            porciones = 2,
            calorias = 380,
            proteinasGramos = 32,
            carbohidratosGramos = 12,
            grasasGramos = 22,
            ingredientes = listOf(
                "2 filetes de salmón",
                "1 manojo de espárragos",
                "1 cucharada de aceite de oliva",
                "Jugo de 1/2 limón",
                "Sal y pimienta a gusto"
            ),
            preparacion = listOf(
                "Cocinar el salmón al vapor durante 10-12 minutos.",
                "Cocinar los espárragos al vapor durante 5 minutos.",
                "Rociar con aceite de oliva y jugo de limón.",
                "Servir caliente con sal y pimienta a gusto."
            ),
            recomendacionNutricional = "El salmón aporta ácidos grasos Omega-3, beneficiosos para la " +
                "salud cardiovascular. Se recomienda incluir pescado al menos 2 veces por semana."
        ),
        Receta(
            id = 4,
            dia = "Jueves",
            nombre = "Lentejas guisadas con verduras",
            descripcion = "Un plato tradicional, económico y muy rico en fibra y hierro.",
            emoji = "🍲",
            tiempoPreparacionMinutos = 45,
            porciones = 3,
            calorias = 350,
            proteinasGramos = 18,
            carbohidratosGramos = 50,
            grasasGramos = 7,
            ingredientes = listOf(
                "2 tazas de lentejas",
                "1 zanahoria en cubos",
                "1/2 cebolla picada",
                "1 diente de ajo picado",
                "1 cucharada de aceite de oliva",
                "1 hoja de laurel",
                "Sal y pimienta a gusto"
            ),
            preparacion = listOf(
                "Sofreír la cebolla y el ajo en aceite de oliva.",
                "Agregar la zanahoria y cocinar por 5 minutos.",
                "Incorporar las lentejas, el laurel y cubrir con agua.",
                "Cocinar a fuego medio hasta que las lentejas estén blandas (30-35 min).",
                "Sazonar con sal y pimienta antes de servir."
            ),
            recomendacionNutricional = "Las legumbres como la lenteja son una fuente económica de " +
                "proteína vegetal y hierro, ideal para complementar la dieta semanal."
        ),
        Receta(
            id = 5,
            dia = "Viernes",
            nombre = "Wrap integral de atún y palta",
            descripcion = "Una opción rápida, práctica y saludable para cerrar la semana.",
            emoji = "🌯",
            tiempoPreparacionMinutos = 15,
            porciones = 2,
            calorias = 340,
            proteinasGramos = 22,
            carbohidratosGramos = 35,
            grasasGramos = 12,
            ingredientes = listOf(
                "2 tortillas integrales",
                "1 lata de atún al agua",
                "1/2 palta",
                "Hojas de lechuga",
                "1 tomate en rodajas",
                "Sal y pimienta a gusto"
            ),
            preparacion = listOf(
                "Escurrir el atún y mezclarlo con la palta machacada.",
                "Calentar levemente las tortillas integrales.",
                "Rellenar con la mezcla de atún y palta, lechuga y tomate.",
                "Enrollar la tortilla y servir de inmediato."
            ),
            recomendacionNutricional = "Ideal para quienes tienen poco tiempo: aporta proteína magra " +
                "del atún y grasas saludables de la palta, en una preparación rápida."
        )
    )

    // el tipo de retorno Receta? (con el signo ?) indica que esta funcion puede
    // devolver null si ningun elemento cumple la condicion. Es la seguridad nula
    // de Kotlin: el codigo que llame a esta funcion queda obligado a manejar ese caso
    fun buscarPorId(id: Int): Receta? = recetas.firstOrNull { it.id == id }
}
