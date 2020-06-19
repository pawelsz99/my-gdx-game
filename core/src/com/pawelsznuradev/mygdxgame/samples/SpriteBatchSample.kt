package com.pawelsznuradev.mygdxgame.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.pawelsznuradev.mygdxgame.common.SamplerBase
import com.pawelsznuradev.mygdxgame.utils.clearScreen
import com.pawelsznuradev.mygdxgame.utils.logger
import com.pawelsznuradev.mygdxgame.utils.toInternalFile
import com.pawelsznuradev.mygdxgame.utils.use

/**
 * @author Pawel Sznura 05/06/2020
 */
class SpriteBatchSample : SamplerBase()  {

    companion object{
        @JvmStatic
        private val log = logger<ModuleInfoSample>()
    }
    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var texture: Texture

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("create()")

        camera = OrthographicCamera()
        viewport = FitViewport(10.80f, 7.20f, camera)
        batch = SpriteBatch()
        texture = Texture("raw/character.png".toInternalFile())
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width,height,true)
    }

    override fun render() {
        //clearing screen
        clearScreen()

        batch.projectionMatrix = camera.combined

        batch.use { draw() }


    }

    private fun draw() {
        val width = 1f
        val height = 1f

        batch.draw(
                texture,
                1f, 1f,
                width / 2f, height / 2f,
                width, height,
                1f, 1f,
                0f,
                0,0,
                texture.width, texture.height,
                false, false
        )

        //scaled
        batch.draw(
                texture,
                4f, 2f,
                width / 2f, height / 2f,
                width, height,
                2f, 2f,
                0f,
                0, 0,
                texture.width, texture.height,
                false, false
        )

        batch.color = Color.CYAN

        batch.draw(
                texture,
                8f, 1f,
                width / 2f, height / 2f,
                width, height,
                2f, 2f,
                0f,
                0, 0,
                texture.width, texture.height,
                false, false
        )


        batch.color = Color.WHITE
    }

    override fun dispose() {
        log.debug("dispose")
        batch.dispose()
        texture.dispose()
    }
}