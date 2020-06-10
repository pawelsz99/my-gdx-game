package com.pawelsznuradev.mygdxgame.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.pawelsznuradev.mygdxgame.ApplicationListenerSample

/**
 * @author Pawel Sznura 05/06/2020
 */

fun main() {

    LwjglApplication(ApplicationListenerSample(), LwjglApplicationConfiguration())

}