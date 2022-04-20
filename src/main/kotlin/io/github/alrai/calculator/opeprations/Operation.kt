package io.github.alrai.calculator.opeprations

import java.util.concurrent.Callable

interface Operation {
    val arity: Int

    fun execute(vararg arg: Double): Double
}