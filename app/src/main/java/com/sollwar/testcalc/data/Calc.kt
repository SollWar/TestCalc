package com.sollwar.testcalc.data

class Calc {

    fun calc(firstArgument: String, secondArgument: String, procedure: String): String {
        val a = firstArgument.toFloat()
        val b = secondArgument.toFloat()
        return when (procedure) {
            "+" -> plus(a, b).toString()
            "-" -> minus(a, b).toString()
            "*" -> multiply(a, b).toString()
            "/" -> divide(a, b).toString()
            else -> "Неверная операция"
        }
    }

    private fun plus(a: Float, b: Float): Float = a + b
    private fun minus(a: Float, b: Float): Float = a - b
    private fun multiply(a: Float, b: Float): Float = a * b
    private fun divide(a: Float, b: Float): Float = a / b

}