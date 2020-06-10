package com.pawelsznuradev.mygdxgame.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.pawelsznuradev.mygdxgame.InputPollingSample

/**
 * @author Pawel Sznura 05/06/2020
 */

fun main() {
    val config = LwjglApplicationConfiguration()
    config.width = 1080
    config.height = 720


    LwjglApplication(InputPollingSample(), config)

}