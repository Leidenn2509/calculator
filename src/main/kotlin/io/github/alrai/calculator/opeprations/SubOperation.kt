package io.github.alrai.calculator.opeprations

class SubOperation : Operation {
    override val arity: Int
        get() = 2

    override fun execute(vararg arg: Double): Double {
        require(arg.size == arity)
        return arg.first() - arg.last()
    }
}