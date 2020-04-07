import java.util.*
import kotlin.math.abs

var N = 0
lateinit var arr : Array<white>

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    arr = Array(N) { white(nextLong(), nextLong())}
    arr.sortBy { it.from }

    var ret = 0L
    var from = Long.MIN_VALUE
    var to = Long.MIN_VALUE

    for(w in arr) {
        val wf = w.from
        val wt = w.to

        if(from <= wf && wt <= to)
            continue
        ret += abs(wf - wt)
        if(wf < to)
            ret -= abs(to - wf)

        from = wf
        to = wt
    }

    println(ret)
}

data class white(val from : Long, val to : Long)
