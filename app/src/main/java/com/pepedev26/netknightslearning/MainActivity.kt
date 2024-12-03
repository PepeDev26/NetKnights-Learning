package com.pepedev26.netknightslearning

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetKnightsLearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndroidView(
                        factory = { context ->
                            LayoutInflater.from(context).inflate(R.layout.menu_principal, null).apply {
                                findViewById<Button>(R.id.button0).setOnClickListener {
                                    Toast.makeText(context, "Botón 0 presionado", Toast.LENGTH_SHORT).show()
                                }
                                findViewById<Button>(R.id.button1).setOnClickListener {
                                    Toast.makeText(context, "Botón 1 presionado", Toast.LENGTH_SHORT).show()
                                }
                                findViewById<Button>(R.id.button2).setOnClickListener {
                                    Toast.makeText(context, "Botón 2 presionado", Toast.LENGTH_SHORT).show()
                                }
                                findViewById<Button>(R.id.button3).setOnClickListener {
                                    Toast.makeText(context, "Botón 3 presionado", Toast.LENGTH_SHORT).show()
                                }
                                findViewById<Button>(R.id.button4).setOnClickListener {
                                    Toast.makeText(context, "Botón 4 presionado", Toast.LENGTH_SHORT).show()
                                }
                            }
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
