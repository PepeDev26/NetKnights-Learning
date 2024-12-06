package com.pepedev26.netknightslearning


object LivesManager {
    var lives: Int = 4

    fun decrementLives() {
        if (lives > 0) {
            lives--
        }
    }

    fun hasLives(): Boolean {
        return lives > 0
    }
}