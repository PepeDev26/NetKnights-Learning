package com.pepedev26.netknightslearning

object GameManager {
    var puntos: Int = 0

    fun agregarPuntos(puntos: Int) {
        this.puntos += puntos
    }

    fun respuestaCorrecta() {
        agregarPuntos(5)
    }

    fun updatePuntos() {
        puntos = 0
    }
}