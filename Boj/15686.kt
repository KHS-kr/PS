import java.util.*
import kotlin.math.abs
import kotlin.math.min

var N = 0; var M = 0
var chicken = mutableListOf<Pair<Int, Int>>()
var home = arrayOf<Pair<Int, Int>>()
var result = 9999
val visited = BooleanArray(14)

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt()

    for(i in 0 until N) {
        for(j in 0 until N) {
            val temp = nextInt()
            if(temp == 1) home += Pair(i, j)
            else if(temp == 2) chicken.add(Pair(i, j))
        }
    }
    DFS(0, 0)
    println(result)
}

fun DFS(idx : Int, chick : Int) {
    if(idx > chicken.size)
        return

    if(chick == M) {
        var temp = 0

        for(i in home.indices) {
            var dist = 9999
            for(j in chicken.indices)
                if(visited[j]) {
                    dist = min(dist, home[i] distance chicken[j])
                }
            temp += dist
        }
        result = min(result, temp)

        return
    }

    visited[idx] = true
    DFS(idx + 1, chick + 1)
    visited[idx] = false
    DFS(idx + 1, chick)
}

infix fun Pair<Int, Int>.distance(another : Pair<Int, Int>)
        = abs(this.first - another.first) + abs(this.second - another.second)
