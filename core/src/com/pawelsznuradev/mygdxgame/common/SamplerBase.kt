package com.pawelsznuradev.mygdxgame.common

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.InputProcessor

/**
 * @author Pawel Sznura 13/06/2020
 */
abstract class SamplerBase : ApplicationAdapter(), InputProcessor {

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int) = false
    override fun mouseMoved(screenX: Int, screenY: Int)= false
    override fun keyTyped(character: Char)= false
    override fun scrolled(amount: Int)= false
    override fun keyUp(keycode: Int)= false
    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int)= false
    override fun keyDown(keycode: Int)= false
    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int)= false



}