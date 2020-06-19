package com.pawelsznuradev.mygdxgame.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.pawelsznuradev.mygdxgame.common.SamplerBase
import com.pawelsznuradev.mygdxgame.utils.clearScreen
import com.pawelsznuradev.mygdxgame.utils.logger
import com.pawelsznuradev.mygdxgame.utils.toInternalFile

/**
 * @author Pawel Sznura 05/06/2020
 */
class BitmapFontSample : SamplerBase()  {

    companion object{
        @JvmStatic
        private val log = logger<ModuleInfoSample>()

        private const val WIDTH = 1080f
        private const val HEIGHT = 720f

    }
    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch

    lateinit var effectFont: BitmapFont
    lateinit var uiFont: BitmapFont

    private val layout = GlyphLayout()

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("create()")

        camera = OrthographicCamera()
        viewport = FitViewport(1080f, 720f, camera)
        batch = SpriteBatch()
       // font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
        effectFont = BitmapFont("fonts/effect_font_32.fnt".toInternalFile())
        uiFont = BitmapFont("fonts/ui_font_32.fnt".toInternalFile())
        uiFont.data.markupEnabled = true


    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width,height,true)
    }

    override fun render() {
        //clearing screen
        clearScreen()

        batch.projectionMatrix = camera.combined
        batch.begin()

        draw()

        batch.end()


    }

    private fun draw() {

        val textOne = "[#FF0000]BITMAP [GREEN]FOKL FDJKSHJK"

        effectFont.draw(batch, textOne, 20f, HEIGHT, 100f, Align.center, true)
        uiFont.draw(batch, textOne, 200f, HEIGHT - 250f, 200f, Align.right, true)

        layout.setText(uiFont, textOne)

        uiFont.draw(batch, layout, (WIDTH - layout.width)/2,
                (HEIGHT - layout.height)/2 )

    }

    override fun dispose() {
        log.debug("dispose")
        batch.dispose()
        effectFont.dispose()
        uiFont.dispose()
    }
}