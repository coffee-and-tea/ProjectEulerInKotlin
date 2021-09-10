package coffee_and_tea.project_euler

/*
* Each new term in the Fibonacci sequence is generated by adding the previous two terms.
* By starting with 1 and 2, the first 10 terms will be:
*
* 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
*
* By considering the terms in the Fibonacci sequence whose values do not exceed four million,
* find the sum of the even-valued terms.
*
* */

object fibGenerator : Iterator<Int> {

    var current_fib = 1
    var next_fib = 2

    override fun hasNext(): Boolean {
        return current_fib <= 4_000_000
    }

    override fun next(): Int {
        val current = current_fib
        current_fib = next_fib
        next_fib = current + current_fib
        println("$current vs $current_fib vs $next_fib")
        return current
    }
}

val result = fibGenerator.asSequence().filter { it % 2 == 0 }.map { it.toLong() }.sum()

fun main() {
    println(result)
}