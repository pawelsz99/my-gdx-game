package com.pawelsznuradev.mygdxgame.common

import com.pawelsznuradev.mygdxgame.samples.*

/**
 * @author Pawel Sznura 13/06/2020
 */
object SampleInfos {
    val allSamples = arrayListOf(
            SampleInfo(ApplicationListenerSample::class.java),
            SampleInfo(GdxGeneratedSample::class.java),
            SampleInfo(InputListeningSample::class.java),
            SampleInfo(InputPollingSample::class.java),
            SampleInfo(ModuleInfoSample::class.java),
            SampleInfo(MultiplexerSample::class.java),
            SampleInfo(ReflectionSample::class.java),
            SampleInfo(OrthographicCameraSample::class.java),
            SampleInfo(ViewportSample::class.java),
            SampleInfo(SpriteBatchSample::class.java),
            SampleInfo(ShapeRendererSample::class.java),
            SampleInfo(BitmapFontSample::class.java)


    )

//    fun getSampleNames(): Array<String>{
//        val names = arrayListOf<String>()
//
//        allSamples.forEach { names.add(it.name) }
//
//        names.sort()
//
//        return names.toTypedArray()
//    }


    fun getSampleNames() = allSamples.associateBy { it.name }
            .keys.toList().sorted().toTypedArray()

    fun find(name: String) = allSamples.find { it.name == name }

}