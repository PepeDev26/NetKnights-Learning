package com.pepedev26.netknightslearning


object LivesManager {
    var lives: Int = 3

    fun decrementLives() {
        if (lives > 0) {
            lives--
        }
    }

    fun hasLives(): Boolean {
        return lives > 0
    }
}