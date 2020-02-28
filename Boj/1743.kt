import java.util.*
import kotlin.math.abs
import kotlin.math.max

lateinit var arr : Array<Array<Char>>
lateinit var visited : Array<Array<Boolean>>
var N = 0; var M = 0; var K = 0
val _x = arrayOf(-1, 0, 1, 0)
val _y = arrayOf(0, -1, 0, 1)

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    K = sc.nextInt()

    arr = Array(N) { Array(M) { '.' } }
    visited = Array(N) { Array(M) { false } }
    val dirties = Array(K) { Dirty(0, 0) }

    for(i in 0 until K) {
        val x = sc.nextInt() - 1
        val y = sc.nextInt() - 1
        arr[x][y] = '#'
        dirties[i] = Dirty(x, y)
    }

    var retval = 0

    for(d in dirties) {
        retval = max(retval, find(d.x, d.y))
    }

    println(retval)
}

data class Dirty(val x : Int, val y : Int)
fun find(x : Int, y : Int) : Int {
    if(x < 0 || y < 0 || x >= N || y >= M) return 0
    if(visited[x][y] || arr[x][y] == '.') return 0

    visited[x][y] = true

    var retval = 1
    for(i in 0 until 4) {
        val newX = x  + _x[i]
        val newY = y + _y[i]
        retval += find(newX, newY)
    }

    return retval
}
