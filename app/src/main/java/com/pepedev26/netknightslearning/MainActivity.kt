package com.pepedev26.netknightslearning

import LivesObserver
import PointsObserver
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pepedev26.netknightslearning.ui.theme.NetKnightsLearningTheme

class MainActivity : ComponentActivity() {
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetKnightsLearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndroidView(
                        factory = { context ->
                            LayoutInflater.from(context).inflate(R.layout.menu_principal, null).apply {
                                findViewById<Button>(R.id.button1).setOnClickListener {
                                    val intent = Intent(context, ActividadEstrella::class.java)
                                    context.startActivity(intent)
                                }
                                findViewById<Button>(R.id.button2).setOnClickListener {
                                    val intent = Intent(context, ActividadContrasena::class.java)
                                    startActivityForResult(intent, REQUEST_CODE)
                                }
                                findViewById<ImageButton>(R.id.buttonExit).setOnClickListener {
                                    AlertDialog.Builder(context).apply {
                                        setTitle("Confirmación")
                                        setMessage("¿Estás seguro de que quieres salir?")
                                        setPositiveButton("Sí") { _, _ ->
                                            finishAffinity() // Cierra la aplicación
                                        }
                                        setNegativeButton("No", null)
                                        create()
                                        show()
                                    }
                                }

                                val indicadorVidas = findViewById<TextView>(R.id.indicadorVidas)
                                indicadorVidas.text = LivesManager.lives.toString()
                                lifecycle.addObserver(LivesObserver(indicadorVidas))
                                lifecycle.addObserver(PointsObserver(findViewById(R.id.puntosescudo)))
                            }
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val puntos = data?.getIntExtra("puntos", 0) ?: 0
            findViewById<TextView>(R.id.puntosescudo).text = puntos.toString()
        }
    }
}