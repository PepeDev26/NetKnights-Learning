package com.pepedev26.netknightslearning

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class ActividadEstrella : ComponentActivity() {

    private val questionsAndOptions = listOf(
        Triple("Pregunta 1", listOf("Opción 1.1", "Opción 1.2", "Opción 1.3", "Opción 1.4"), 0),
        Triple("Pregunta 2", listOf("Opción 2.1", "Opción 2.2", "Opción 2.3", "Opción 2.4"), 1),
        Triple("Pregunta 3", listOf("Opción 3.1", "Opción 3.2", "Opción 3.3", "Opción 3.4"), 2),
        Triple("Pregunta 4", listOf("Opción 4.1", "Opción 4.2", "Opción 4.3", "Opción 4.4"), 3),
        Triple("Pregunta 5", listOf("Opción 5.1", "Opción 5.2", "Opción 5.3", "Opción 5.4"), 0)
    ).shuffled()

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_estrella)

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
    }

    private fun showQuestion() {
        val (question, options, _) = questionsAndOptions[currentQuestionIndex]
        findViewById<TextView>(R.id.questionTextView).text = question
        findViewById<Button>(R.id.optionButton1).text = options[0]
        findViewById<Button>(R.id.optionButton2).text = options[1]
        findViewById<Button>(R.id.optionButton3).text = options[2]
        findViewById<Button>(R.id.optionButton4).text = options[3]
        updateLivesIndicator()
    }

    private fun checkAnswer(selectedOptionIndex: Int) {
        val (_, _, correctOptionIndex) = questionsAndOptions[currentQuestionIndex]
        if (selectedOptionIndex == correctOptionIndex) {
            Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show()
            LivesManager.decrementLives()
            updateLivesIndicator()
            if (!LivesManager.hasLives()) {
                Toast.makeText(this, "No tienes vidas suficientes para continuar.", Toast.LENGTH_LONG).show()
                finish()
                return
            }
        }

        currentQuestionIndex++
        if (currentQuestionIndex < questionsAndOptions.size) {
            showQuestion()
        } else {
            Toast.makeText(this, "Has completado todas las preguntas!", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateLivesIndicator() {
        findViewById<TextView>(R.id.indicadorVidas).text = LivesManager.lives.toString()
    }
}