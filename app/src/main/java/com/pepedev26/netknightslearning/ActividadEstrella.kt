package com.pepedev26.netknightslearning

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class ActividadEstrella : ComponentActivity() {

    private val questionsAndOptions = listOf(
        Pair("Pregunta 1", listOf("Opción 1.1", "Opción 1.2", "Opción 1.3", "Opción 1.4")),
        Pair("Pregunta 2", listOf("Opción 2.1", "Opción 2.2", "Opción 2.3", "Opción 2.4")),
        Pair("Pregunta 3", listOf("Opción 3.1", "Opción 3.2", "Opción 3.3", "Opción 3.4")),
        Pair("Pregunta 4", listOf("Opción 4.1", "Opción 4.2", "Opción 4.3", "Opción 4.4")),
        Pair("Pregunta 5", listOf("Opción 5.1", "Opción 5.2", "Opción 5.3", "Opción 5.4"))
    ).shuffled()

    private val correctAnswers = listOf(0, 1, 2, 3, 0) // Índices de las respuestas correctas

    private var currentQuestionIndex = 0
    private var currentOptions = listOf<Pair<String, Int>>()
    private var lives = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_estrella)

        showQuestion()

        findViewById<Button>(R.id.optionButton1).setOnClickListener { checkAnswer(0) }
        findViewById<Button>(R.id.optionButton2).setOnClickListener { checkAnswer(1) }
        findViewById<Button>(R.id.optionButton3).setOnClickListener { checkAnswer(2) }
        findViewById<Button>(R.id.optionButton4).setOnClickListener { checkAnswer(3) }
    }

    private fun showQuestion() {
        val (question, options) = questionsAndOptions[currentQuestionIndex]
        findViewById<TextView>(R.id.questionTextView).text = question
        currentOptions = options.mapIndexed { index, option -> option to index }.shuffled()
        findViewById<Button>(R.id.optionButton1).text = currentOptions[0].first
        findViewById<Button>(R.id.optionButton2).text = currentOptions[1].first
        findViewById<Button>(R.id.optionButton3).text = currentOptions[2].first
        findViewById<Button>(R.id.optionButton4).text = currentOptions[3].first
    }

    private fun checkAnswer(selectedOptionIndex: Int) {
        val correctOptionIndex = correctAnswers[currentQuestionIndex]
        if (currentOptions[selectedOptionIndex].second == correctOptionIndex) {
            Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show()
            lives--
            updateLivesIndicator()
        }

        currentQuestionIndex++
        if (currentQuestionIndex < questionsAndOptions.size) {
            showQuestion()
        } else {
            Toast.makeText(this, "Has completado todas las preguntas!", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateLivesIndicator() {
        findViewById<TextView>(R.id.indicadorVidas).text = lives.toString()
    }
}