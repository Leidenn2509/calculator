package io.github.alrai.calculator


sealed class Token(val token: String)

class OperationToken(token: String): Token(token)
class OperandToken(token: String, val number: Double = token.toDouble()): Token(token)

