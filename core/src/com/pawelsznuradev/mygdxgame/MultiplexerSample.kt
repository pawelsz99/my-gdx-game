package com.pawelsznuradev.mygdxgame

import com.badlogic.gdx.*
import com.pawelsznuradev.mygdxgame.utils.logger

/**
 * @author Pawel Sznura 05/06/2020
 */
class MultiplexerSample : ApplicationAdapter() {

    companion object {
        @JvmStatic
        private val log = logger<MultiplexerSample>()
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

//        val multiplexer = InputMultiplexer()

        // annonymous inner class
        val firstProcessor = object : InputAdapter() {
            override fun keyDown(keycode: Int): Boolean {
                log.debug("first keyDown keycode = $keycode")
                return true
            }

            override fun keyUp(keycode: Int): Boolean {
                log.debug("first keyUp keycode = $keycode")
                return false
            }
        }


        val secondProcessor = object : InputAdapter() {
            override fun keyDown(keycode: Int): Boolean {
                log.debug("first keyDown keycode = $keycode")
                return true
            }

            override fun keyUp(keycode: Int): Boolean {
                log.debug("first keyUp keycode = $keycode")
                return false
            }
        }
//
//        multiplexer.addProcessor(firstProcessor)
//        multiplexer.addProcessor(secondProcessor)

        Gdx.input.inputProcessor = InputMultiplexer(firstProcessor, secondProcessor)


    }
}