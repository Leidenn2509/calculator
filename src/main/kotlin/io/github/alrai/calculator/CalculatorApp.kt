package io.github.alrai.calculator

fun main() {
    val input = readLine() ?: return
    val res = Calculator().calculate(input)
    println("$input = $res")
}