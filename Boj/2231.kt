import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()

    println(bunhae(N))
}

fun bunhae(n : Int) : Int {
    for(i in 1 until n) {
        if(i.hab() == n)
            return i
    }

    return 0
}

fun Int.hab() : Int {
    var sum = this
    for(c in this.toString()) {
        sum += c.toInt() - 48
    }
    return sum
}
