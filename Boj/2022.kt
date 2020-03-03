import java.util.*
import kotlin.math.min
import kotlin.math.round
import kotlin.math.sqrt

var x = 0.0
var y = 0.0
var c = 0.0

fun main() {
    val sc = Scanner(System.`in`)

    x = sc.nextDouble()
    y = sc.nextDouble()
    c = sc.nextDouble()

    var h = min(x, y)
    var l = 0.0
    var retval = 0.0

    while(h - l > 0.000001) {
        val w = (h + l) / 2
        if(cal_c(w) >= c) {
            retval = w
            l = w
        }
        else
            h = w
    }

    println("${round(retval * 1000) / 1000}")
}

fun cal_c(w : Double) : Double{
    val h1 = sqrt(x * x - w * w)
    val h2 = sqrt(y * y - w * w)

    return (h1 * h2) / (h1 + h2)
}
