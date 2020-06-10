package com.pawelsznuradev.mygdxgame

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.pawelsznuradev.mygdxgame.utils.clearScreen

/**
 * @author Pawel Sznura 05/06/2020
 */
class MyGdxGame : ApplicationAdapter() {

    lateinit var batch: SpriteBatch
    lateinit var img: Texture

    override fun create() {
        batch= SpriteBatch()
        img= Texture("badlogic.jpg")

    }

    override fun render() {
        clearScreen()

        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}