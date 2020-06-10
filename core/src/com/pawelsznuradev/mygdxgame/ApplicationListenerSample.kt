package com.pawelsznuradev.mygdxgame

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.pawelsznuradev.mygdxgame.utils.logger

/**
 * @author Pawel Sznura 05/06/2020
 */
class ApplicationListenerSample : ApplicationListener{

    companion object{

        @JvmStatic
        //without util class
        //private val log = Logger(ApplicationListenerSample::class.java.simpleName, Logger.DEBUG)

        //using util class
        //private val log = logger(ApplicationListenerSample::class.java)

        //using inline util class
        private val log = logger<ApplicationListenerSample>()
    }

    private var renderInterrupted = true

    override fun create() {
        // use to initialize game and load resources
        //Gdx.app.debug("ApplicationListenerSample", "create()")
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug("create()")
    }

    override fun resize(width: Int, height: Int) {
        // used to handle settings a new screen size

        log.debug("resize()")
    }

    override fun render() {
        //update the screen (60fps)

        if(renderInterrupted){
            log.debug("render()")
            renderInterrupted = false
        }

    }

    override fun pause() {

        log.debug("pause()")
        renderInterrupted = true
    }

    override fun resume() {

        log.debug("resume()")
        renderInterrupted = true
    }


    override fun dispose() {
        // free resources and cleanup
        log.debug("dispose()")
    }


//    lateinit var batch: SpriteBatch
//    lateinit var img: Texture
//
//    override fun create() {
//        batch= SpriteBatch()
//        img= Texture("badlogic.jpg")
//
//    }
//
//    override fun render() {
//        Gdx.gl.glClearColor(1F, 0F, 0F, 1F)
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
//        batch.begin()
//        batch.draw(img, 0f, 0f)
//        batch.end()
//    }
//
//    override fun dispose() {
//        batch.dispose()
//        img.dispose()
//    }
}