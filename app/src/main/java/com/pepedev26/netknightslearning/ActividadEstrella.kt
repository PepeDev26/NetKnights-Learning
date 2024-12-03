package com.pepedev26.netknightslearning

class ActividadEstrella {
    val preguntas = listOf(
        Pregunta("¿Cuál es la capital de Francia?", listOf("París", "Londres", "Madrid"), 0),
        Pregunta("¿Cuál es el resultado de 2+2?", listOf("3", "4", "5"), 1),
        Pregunta("¿Cuál es el océano más grande?", listOf("Atlántico", "Índico", "Pacífico"), 2)
    )
    var indicePregunta = 0
    var vidas = 3
    var puntos = 0

    fun iniciarJuego() {
        // Lógica del juego
    }

    fun responder(respuestaUsuario: Int) {
        val preguntaActual = preguntas[indicePregunta]
        if (respuestaUsuario == preguntaActual.respuestaCorrecta) {
            puntos += 10
            indicePregunta++
        } else {
            vidas--
        }
        iniciarJuego()
    }

    data class Pregunta(val texto: String, val respuestas: List<String>, val respuestaCorrecta: Int)
}