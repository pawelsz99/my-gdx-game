package com.pawelsznuradev.mygdxgame.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20

/**
 * @author Pawel Sznura 10/06/2020
 */

fun clearScreen(color: Color = Color.BLACK) = clearScreen(color.r, color.g, color.b, color.a)

fun clearScreen(red: Float, green: Float, blue: Float, alpha: Float){
    Gdx.gl.glClearColor(0F, 0F, 0F, 1F)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

}

