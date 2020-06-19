package com.pawelsznuradev.mygdxgame.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.reflect.ClassReflection
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.pawelsznuradev.mygdxgame.common.SamplerBase
import com.pawelsznuradev.mygdxgame.utils.clearScreen
import com.pawelsznuradev.mygdxgame.utils.logger
import com.pawelsznuradev.mygdxgame.utils.toInternalFile

/**
 * @author Pawel Sznura 05/06/2020
 */
class ReflectionSample : SamplerBase()  {

    companion object {
        @JvmStatic
        private val log = logger<ReflectionSample>()
    }


    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: Viewport
    private lateinit var batch: SpriteBatch
    private lateinit var font: BitmapFont

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("crete()")

        camera = OrthographicCamera()
        viewport = FitViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        //font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())

        debugReflection<ReflectionSample>()
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
        // mouse x y
        val mouseX = Gdx.input.x
        val mouseY = Gdx.input.y

        val leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        val rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT)
        val middlePressed = Gdx.input.isButtonPressed(Input.Buttons.MIDDLE)

        font.draw(batch, "MouseX = $mouseX , MouseY = $mouseY", 20f, 720f - 20f)


        val leftPressedString = if(leftPressed) "Left button pressed" else "Left not pressed"
        val rightPressedString = if(rightPressed) "Right button pressed" else "Right not pressed"
        val middlePressedString = if(middlePressed) "middle button pressed" else "middle not pressed"

        font.draw(batch, leftPressedString, 20f, 720f - 50f )
        font.draw(batch, rightPressedString, 20f, 720f - 80f )
        font.draw(batch, middlePressedString, 20f, 720f - 110f )

        //keys
        val wPressed = Gdx.input.isKeyPressed(Input.Keys.W)
        val sPressed = Gdx.input.isKeyPressed(Input.Keys.S)
        val dPressed = Gdx.input.isKeyPressed(Input.Keys.D)
        val aPressed = Gdx.input.isKeyPressed(Input.Keys.A)

        font.draw(batch,
                if(wPressed) "W is pressed" else "W is not pressed",
                20f, 720f - 140f)
        font.draw(batch,
                if(sPressed) "S is pressed" else "S is not pressed",
                20f, 720f - 170f)
        font.draw(batch,
                if(dPressed) "D is pressed" else "D is not pressed",
                20f, 720f - 200f)
        font.draw(batch,
                if(aPressed) "A is pressed" else "A is not pressed",
                20f, 720f - 230f)


    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }


    private inline fun <reified T: Any> debugReflection(){
        val fields = ClassReflection.getDeclaredFields(T::class.java)
        val methods = ClassReflection.getDeclaredMethods(T::class.java)

        log.debug("reflection class= ${T::class.java.simpleName}")
        log.debug("fields count= ${fields.size}")

        for ( field in fields){
            log.debug("name= ${field.name}  type= ${field.type}")
        }

        log.debug("method count = ${methods.size}")

        methods.forEach {
            log.debug("name = ${it.name}")
        }

    }
}