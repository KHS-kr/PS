import java.util.*

var N = 0; var M = 0
lateinit var arr : IntArray

fun main() = with(Scanner(System .`in`)) {
    N = nextInt(); M = nextInt()
    arr = IntArray(N) { nextInt() }

    var left = 0; var right = arr.max()!!

    while(left + 1 < right) {
        val mid = (left + right) / 2
        var sum = arr cut mid

        if(sum >= M)
            left = mid
        else
            right = mid
    }

    println(left)
}

infix fun IntArray.cut(x : Int) : Long {
    var ret = 0L
    for(i in this)
        if(i - x > 0)
            ret += i - x

    return ret
}
