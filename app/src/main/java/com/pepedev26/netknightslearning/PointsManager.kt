package com.pepedev26.netknightslearning

import android.content.Context
import android.content.SharedPreferences

// Objeto singleton para gestionar los puntos del usuario
object PointsManager {
    // Nombre del archivo de preferencias compartidas
    private const val PREFS_NAME = "points_prefs"
    // Clave para almacenar los puntos en las preferencias compartidas
    private const val POINTS_KEY = "points"
    // Variable para acceder a las preferencias compartidas
    private lateinit var preferences: SharedPreferences

    // Propiedad para obtener y establecer los puntos
    var points: Int
        get() = preferences.getInt(POINTS_KEY, 0) // Obtiene los puntos almacenados, por defecto 0
        set(value) {
            preferences.edit().putInt(POINTS_KEY, value).apply() // Almacena los puntos en las preferencias compartidas
        }

    // Inicializa el objeto con el contexto de la aplicación
    fun initialize(context: Context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // Añade puntos al total actual
    fun addPoints(value: Int) {
        points += value
    }

    // Resetea los puntos a 0
    fun resetPoints() {
        points = 0
    }
}