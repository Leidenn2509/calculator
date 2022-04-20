package io.github.alrai.calculator

import io.github.alrai.calculator.opeprations.Operation

interface OperationFactory {
    fun createFromText(text: String): Operation
}