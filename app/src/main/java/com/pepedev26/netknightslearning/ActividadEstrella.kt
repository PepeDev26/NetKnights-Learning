package com.pepedev26.netknightslearning

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class ActividadEstrella : ComponentActivity() {

        private val questionsAndOptions = listOf(
            Triple("¿Qué es un firewall?", listOf("Un tipo de virus", "Un software de ofimática", "Un protocolo de red", "Un dispositivo que filtra el tráfico de red"), 3),
            Triple("¿Qué es una VPN?", listOf("Una red privada virtual", "Un tipo de malware", "Un protocolo de correo electrónico", "Un tipo de hardware"), 0),
            Triple("¿Qué es un ataque de ingeniería social?", listOf("Un tipo de firewall", "Un tipo de malware", "Un ataque de denegación de servicio", "Un intento de manipular a las personas para obtener información confidencial"), 3),
            Triple("¿Qué es un ataque de fuerza bruta?", listOf("Un software de cifrado", "Un tipo de firewall", "Un protocolo de red", "Un intento de adivinar contraseñas"), 3),
            Triple("¿Qué es un ataque de phishing?", listOf("Un ataque de denegación de servicio", "Un intento de obtener información confidencial", "Un tipo de malware", "Un tipo de firewall"), 1),
            Triple("¿Qué es el cifrado?", listOf("El proceso de convertir datos en un código", "Un tipo de ataque cibernético", "Un software antivirus", "Un tipo de hardware"), 0),
            Triple("¿Qué es un troyano?", listOf("Un software de ofimática", "Un dispositivo que filtra el tráfico de red", "Un tipo de malware que se disfraza de software legítimo", "Un protocolo de red"), 2),
            Triple("¿Qué es un ransomware?", listOf("Un tipo de firewall", "Un protocolo de red", "Un software de cifrado", "Un tipo de malware que cifra los datos y pide un rescate"), 3),
            Triple("¿Qué es un ataque de día cero?", listOf("Un ataque que explota una vulnerabilidad desconocida", "Un software antivirus", "Un tipo de malware", "Un tipo de hardware"), 0),
            Triple("¿Qué es un ataque de denegación de servicio (DoS)?", listOf("Un software de cifrado", "Un protocolo de red", "Un intento de hacer que un servicio no esté disponible", "Un tipo de firewall"), 2),
            Triple("¿Qué es una cookie en informática?", listOf("Un archivo que almacena datos del usuario", "Un tipo de malware", "Un software de seguridad", "Un protocolo de red"), 0),
            Triple("¿Qué es la ingeniería inversa?", listOf("Un software para proteger datos", "El proceso de analizar cómo funciona un sistema", "Un ataque cibernético", "Un dispositivo de red"), 1),
            Triple("¿Qué es un proxy?", listOf("Un tipo de ataque", "Un software de cifrado", "Un servidor que actúa como intermediario", "Un hardware de red"), 2),
            Triple("¿Qué es el phishing telefónico (vishing)?", listOf("Un ataque que explota vulnerabilidades", "Un ataque que utiliza llamadas telefónicas para obtener información confidencial", "Un software malicioso", "Un tipo de firewall"), 1),
            Triple("¿Qué es un botnet?", listOf("Un tipo de malware", "Un dispositivo que filtra el tráfico", "Un conjunto de dispositivos comprometidos usados para ataques", "Un software de seguridad"), 2),
            Triple("¿Qué es un certificado digital?", listOf("Un archivo que verifica la identidad en línea", "Un tipo de malware", "Un protocolo de red", "Un dispositivo de cifrado"), 0),
            Triple("¿Qué es un ataque de spoofing?", listOf("Un software antivirus", "Un ataque de denegación de servicio", "Un tipo de firewall", "Suplantar una identidad para engañar"), 3),
            Triple("¿Qué es un keylogger?", listOf("Un software para proteger contraseñas", "Un dispositivo de red", "Un software que registra las pulsaciones del teclado", "Un tipo de cifrado"), 2),
            Triple("¿Qué es un ataque MITM (Man-In-The-Middle)?", listOf("Interceptar y alterar comunicaciones entre dos partes", "Un tipo de firewall", "Un software de seguridad", "Un ataque de fuerza bruta"), 0),
            Triple("¿Qué es un IDS (Sistema de detección de intrusos)?", listOf("Un protocolo de red", "Un tipo de malware", "Un software de cifrado", "Un sistema que detecta actividades sospechosas en la red"), 3),
            Triple("¿Qué es el hashing?", listOf("Un ataque de fuerza bruta", "Un protocolo de red", "Un tipo de malware", "El proceso de generar un resumen único de datos"), 3),
            Triple("¿Qué es un ataque de SQL Injection?", listOf("Un dispositivo de red", "Un software que cifra contraseñas", "Una técnica para inyectar código malicioso en bases de datos", "Un tipo de cifrado"), 2),
            Triple("¿Qué es el factor de autenticación?", listOf("Un tipo de malware", "Un software de seguridad", "Un ataque de denegación de servicio", "Un método para verificar la identidad de un usuario"), 3),
            Triple("¿Qué es el malware?", listOf("Un tipo de firewall", "Un sistema operativo", "Software diseñado para causar daño", "Un dispositivo de red"), 2),
            Triple("¿Qué es el spam?", listOf("Un protocolo de red", "Mensajes no solicitados enviados en masa", "Un tipo de ataque", "Un software antivirus"), 1),
            Triple("¿Qué es una contraseña segura?", listOf("Una combinación compleja de caracteres", "Una palabra sencilla", "Un tipo de malware", "Un software de cifrado"), 0),
            Triple("¿Qué es un sistema operativo?", listOf("Un tipo de ataque", "Software que gestiona los recursos del hardware", "Un dispositivo de red", "Un protocolo de cifrado"), 1),
            Triple("¿Qué es el phishing por correo electrónico?", listOf("Un software antivirus", "Un protocolo de red", "Un dispositivo de cifrado", "Un ataque que utiliza correos fraudulentos para robar información"), 3),
            Triple("¿Qué es una puerta trasera (backdoor)?", listOf("Un dispositivo de red", "Un acceso no autorizado a un sistema", "Un tipo de cifrado", "Un software de seguridad"), 1),
            Triple("¿Qué es una actualización de seguridad?", listOf("Un parche para corregir vulnerabilidades en el software", "Un software de cifrado", "Un tipo de malware", "Un protocolo de red"), 0)
        ).shuffled().take(5)

    private var currentQuestionIndex = 0
    private lateinit var correctSound: MediaPlayer
    private lateinit var incorrectSound: MediaPlayer
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_estrella)

        correctSound = MediaPlayer.create(this, R.raw.correcta)
        incorrectSound = MediaPlayer.create(this, R.raw.incorrecta)
        progressBar = findViewById(R.id.progressBar)

        if (!LivesManager.hasLives()) {
            Toast.makeText(this, "No tienes vidas suficientes para jugar.", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        showQuestion()

        findViewById<Button>(R.id.optionButton1).setOnClickListener { checkAnswer(0) }
        findViewById<Button>(R.id.optionButton2).setOnClickListener { checkAnswer(1) }
        findViewById<Button>(R.id.optionButton3).setOnClickListener { checkAnswer(2) }
        findViewById<Button>(R.id.optionButton4).setOnClickListener { checkAnswer(3) }
        findViewById<Button>(R.id.atras).setOnClickListener { onBackPressed() }
    }

    private fun showQuestion() {
        val (question, options, _) = questionsAndOptions[currentQuestionIndex]
        findViewById<TextView>(R.id.questionTextView).text = question
        findViewById<Button>(R.id.optionButton1).text = options[0]
        findViewById<Button>(R.id.optionButton2).text = options[1]
        findViewById<Button>(R.id.optionButton3).text = options[2]
        findViewById<Button>(R.id.optionButton4).text = options[3]
        updateProgressBar()
        updateLivesIndicator()
        updatePuntos()
    }

    private fun checkAnswer(selectedOptionIndex: Int) {
        val (_, options, correctOptionIndex) = questionsAndOptions[currentQuestionIndex]
        if (selectedOptionIndex == correctOptionIndex) {
            correctSound.start()
            GameManager.respuestaCorrecta()
            updatePuntos()
            AlertDialog.Builder(this)
                .setTitle("Respuesta")
                .setMessage("¡Correcto!")
                .setPositiveButton("OK", null)
                .show()
        } else {
            incorrectSound.start()
            AlertDialog.Builder(this)
                .setTitle("Respuesta")
                .setMessage("Incorrecto. La respuesta correcta es: ${options[correctOptionIndex]}")
                .setPositiveButton("OK", null)
                .show()
            LivesManager.decrementLives()
            updateLivesIndicator()
            if (!LivesManager.hasLives()) {
                AlertDialog.Builder(this)
                    .setTitle("Fin del juego")
                    .setMessage("No tienes vidas suficientes para continuar.")
                    .setPositiveButton("OK") { _, _ -> finish() }
                    .show()
                return
            }
        }

        currentQuestionIndex++
        if (currentQuestionIndex < questionsAndOptions.size) {
            showQuestion()
        } else {
            val intent = Intent(this, FinNivel::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateLivesIndicator() {
        findViewById<TextView>(R.id.indicadorVidas).text = LivesManager.lives.toString()
    }

    private fun updateProgressBar() {
        val progress = ((currentQuestionIndex + 1) / questionsAndOptions.size.toFloat()) * 100
        progressBar.progress = progress.toInt()
    }

    private fun updatePuntos() {
        findViewById<TextView>(R.id.indicadorPuntos).text = GameManager.puntos.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        correctSound.release()
        incorrectSound.release()
    }
}