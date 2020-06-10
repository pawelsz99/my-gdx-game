package com.pawelsznuradev.mygdxgame.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle

/**
 * @author Pawel Sznura 10/06/2020
 */

fun String.toInternalFile() : FileHandle = Gdx.files.internal(this)
