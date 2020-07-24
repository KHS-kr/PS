import java.util.*

const val INF = Int.MAX_VALUE
const val MAX_VERTICES = 7
var weight = arrayOf(
    intArrayOf(0, 29, INF, INF, INF, 10, INF),
    intArrayOf(29, 0, 16, INF, INF, INF, 15),
    intArrayOf(INF, 16, 0, 12, INF, INF, INF),
    intArrayOf(INF, INF, 12, 0, 22, INF, 18),
    intArrayOf(INF, INF, INF, 22, 0, 27, 25),
    intArrayOf(10, INF, INF, INF, 27, 0, INF),
    intArrayOf(INF, 15, INF, 18, 25, INF, 0)
)
val selected = BooleanArray(MAX_VERTICES) { false }
val dist = IntArray(MAX_VERTICES) { 0 }

fun get_min_vertex(n : Int) : Int {
    var v = 0

    for(i in 0 until n)
        if (!selected[i]) {
            v = i
            break
        }

    for(i in 0 until n)
        if(!selected[i] && dist[i] < dist[v])
            v = i

    return v
}

fun prim(s : Int, n : Int) {
    for(i in 0 until n) {
        dist[i] = INF
        selected[i] = false
    }

    dist[s] = 0

    for(i in 0 until n) {
        val u = get_min_vertex(n)
        selected[u] = true

        if(dist[u] == INF)
            return

        print("$u ")

        for(v in 0 until n) {
            if(weight[u][v] != INF) {
                if(!selected[v] && weight[u][v] < dist[v])
                    dist[v] = weight[u][v]
            }
        }
    }
}

fun main() = with(Scanner(System.`in`)) {
    prim(0, MAX_VERTICES)
}
