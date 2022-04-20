package io.github.alrai.calculator

import java.util.Stack

class Calculator {
    private var stack: Stack<Double> = Stack()
    private val factory: OperationFactory = DoubleOperationFactory()

    fun calculate(input: String): Double {
        input.trim()
            .split(" ")
            .map(::parse)
            .reversed()
            .forEach(::execute)
        require(stack.size == 1) { "Something went wrong" }
        return stack.pop()
    }

    private fun parse(string: String): Token {
        val number = string.toDoubleOrNull()
        return number?.let { OperandToken(string, it) } ?: OperationToken(string)
    }

    private fun execute(token: Token) {
        when (token) {
            is OperandToken -> stack.push(token.number)
            is OperationToken -> {
                val op = factory.createFromText(token.token)
                val arity = op.arity
                val args = mutableListOf<Double>()
                repeat(arity) {
                    args.add(stack.pop())
                }
                stack.push(op.execute(*args.toDoubleArray()))
            }
        }
    }
}