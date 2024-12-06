package com.pepedev26.netknightslearning

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class FinNivel : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.finactividad)

        val btnVolverMenu: Button = findViewById(R.id.botonRegresar)
        val indicadorVidas: TextView = findViewById(R.id.indicadorVidas)
        val indicadorPuntos: TextView = findViewById(R.id.indicadorPuntos)

        // Actualiza los textos de puntos y vidas
        indicadorVidas.text = "${LivesManager.lives}"
        indicadorPuntos.text = "${GameManager.puntos}"

        btnVolverMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    val ratingBar: RatingBar = findViewById(R.id.ratingBar)
    ratingBar.setOnRatingBarChangeListener { _, _, _ ->
        Toast.makeText(this, "¡Gracias por tu valoración!", Toast.LENGTH_SHORT).show()
    }

}
}
