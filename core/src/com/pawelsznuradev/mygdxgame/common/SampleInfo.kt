package com.pawelsznuradev.mygdxgame.common

/**
 * @author Pawel Sznura 13/06/2020
 */
class SampleInfo(val clazz: Class<out SamplerBase>) {

    val name: String = clazz.simpleName
}