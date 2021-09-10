package coffee_and_tea.project_euler

/*
* The prime factors of 13195 are 5, 7, 13 and 29.
*
* What is the largest prime factor of the number 600851475143 ?
* */

var target = 600_851_475_143

var primes = mutableListOf(2L)

object primeGenerator : Iterator<Long> {

    var current: Long = 2

    override fun hasNext(): Boolean {
        return true
    }

    override fun next(): Long {
        val res = current
        while (true) {
            current++
            if (primes.filter { current % it == 0L }.count() == 0) {
                primes.add(current)
                break;
            }
        }
        return res
    }
}

fun main() {
    var prime = primeGenerator.next()

    while(prime * prime <= target) {
        if(target % prime == 0L) {
            target = target / prime
        }
        prime = primeGenerator.next()
    }

    println(target)
}
