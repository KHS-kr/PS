import java.util.*
import kotlin.math.abs
import kotlin.math.min

var h = 0; var w = 0

fun main() {
    val sc = Scanner(System.`in`)
    w = sc.nextInt()
    h = sc.nextInt()
    val n = sc.nextInt()
    val shops = Array(n) { Point(sc.nextInt(), sc.nextInt()) }
    val dg = Point(sc.nextInt(), sc.nextInt())
    var ret = 0
    for(s in shops)
        ret += dg distance s
    

    println(ret)
}

infix fun Point.distance(other : Point) : Int {
    return if(this.nswe == other.nswe)
        abs(this.x - other.x)
    else if((this.nswe == 1 && other.nswe == 2) || (this.nswe == 2 && other.nswe == 1))
        return h + min(this.x + other.x, 2 * w - this.x - other.x)
    else if((this.nswe == 3 && other.nswe == 4) || (this.nswe == 4 && other.nswe == 3))
        return w + min(this.x + other.x, 2 * h - this.x - other.x)
    else {
        when(this.nswe) {
            1 -> {
                return if(other.nswe == 3) this.x + other.x
                else (w - this.x) + other.x
            }
            2 -> {
                return if(other.nswe == 3) this.x + (h - other.x)
                else (w - this.x) + (h - other.x)
            }
            3 -> {
                return if(other.nswe == 1) this.x + other.x
                else (h - this.x) + other.x
            }
            4 -> {
                return if(other.nswe == 1) this.x + (w - other.x)
                else (h - this.x) + (w - other.x)
            }
        }
        return 0
    }
}

data class Point(val nswe : Int, val x : Int)
