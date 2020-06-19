package com.pawelsznuradev.mygdxgame.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.pawelsznuradev.mygdxgame.common.SamplerBase
import com.pawelsznuradev.mygdxgame.utils.logger

/**
 * @author Pawel Sznura 05/06/2020
 */
class ModuleInfoSample : SamplerBase()  {

    companion object{
        @JvmStatic
        private val log = logger<ModuleInfoSample>()
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("app = ${Gdx.app}")
        log.debug("audio = ${Gdx.audio}")
        log.debug("input = ${Gdx.input}")
        log.debug("files = ${Gdx.files}")
        log.debug("net = ${Gdx.net}")
        log.debug("graphics = ${Gdx.graphics}")


    }
}