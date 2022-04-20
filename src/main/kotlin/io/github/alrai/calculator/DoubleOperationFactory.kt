package io.github.alrai.calculator

import io.github.alrai.calculator.opeprations.Operation
import io.github.alrai.calculator.opeprations.SubOperation
import io.github.alrai.calculator.opeprations.SumOperation

class DoubleOperationFactory: OperationFactory {
    override fun createFromText(text: String): Operation = when(text) {
        "+" -> SumOperation()
        "-" -> SubOperation()
        else -> error("Cant create operation from $text")
    }
}