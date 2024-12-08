package com.pepedev26.netknightslearning

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class ActividadContrasena : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.act_contrasena)

        val botonVolver = findViewById<ImageView>(R.id.botonVolver)
        val editTextText2 = findViewById<EditText>(R.id.editTextText2)
        val botonEvaluar = findViewById<Button>(R.id.botonEvaluar)
        val puntosTextView = findViewById<TextView>(R.id.puntos)

        botonEvaluar.setOnClickListener {
            val contrasena = editTextText2.text.toString()
            val puntuacion = evaluarContrasena(contrasena)
            GameManager.puntos += puntuacion
            puntosTextView.text = GameManager.puntos.toString()
            Toast.makeText(this, "Puntuación: $puntuacion", Toast.LENGTH_SHORT).show()
        }

        botonVolver.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("puntos", GameManager.puntos)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    fun evaluarContrasena(contrasena: String): Int {
        var puntuacion = 0

        if (contrasena == "123456") puntuacion = 0
        if (contrasena == "contraseñä") puntuacion = 0
        if (contrasena == "llevalatararaunvestidoblancollenodecascabeles") puntuacion += 28 //Easter egg hacia la antigua contraseña del andared
        if (contrasena.length >= 12) puntuacion += 2
        if (contrasena.any { it.isUpperCase() }) puntuacion += 2
        if (contrasena.any { it.isLowerCase() }) puntuacion += 2
        if (contrasena.any { it.isDigit() }) puntuacion += 2
        if (contrasena.any { !it.isLetterOrDigit() }) puntuacion += 2

        return puntuacion
    }

    override fun onBackPressed() {
        val resultIntent = Intent()
        resultIntent.putExtra("puntos", GameManager.puntos)
        setResult(Activity.RESULT_OK, resultIntent)
        super.onBackPressed()
    }
}