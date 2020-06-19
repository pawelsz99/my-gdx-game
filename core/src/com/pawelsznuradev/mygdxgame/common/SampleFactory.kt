package com.pawelsznuradev.mygdxgame.common

import com.badlogic.gdx.utils.reflect.ClassReflection

/**
 * @author Pawel Sznura 13/06/2020
 */
object SampleFactory {

    fun newSample(name: String) : SamplerBase{
        val info = SampleInfos.find(name)
        return ClassReflection.newInstance(info?.clazz)
    }

}