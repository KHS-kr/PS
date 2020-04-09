import java.util.*

var N = 0; var M = 0
lateinit var arr : Array<IntArray>
lateinit var visited : Array<IntArray>
val dir = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

fun main() = with(Scanner(System .`in`)) {
    N = nextInt(); M = nextInt()
    arr = Array(N) { IntArray(M) { nextInt() } }
    visited = Array(N) { IntArray(M) { -1 } }
    println(dfs(N - 1, M - 1))
}

fun dfs(x : Int, y : Int) : Int {
    if(x == 0 && y == 0) {
        return 1
    }

    if(visited[x][y] == -1) {
        visited[x][y] = 0

        for (d in dir) {
            val tx = x + d.first
            val ty = y + d.second
            if (tx in 0 until N && ty in 0 until M && arr[x][y] < arr[tx][ty]) {
                visited[x][y] += dfs(tx, ty)
            }
        }
    }

    return visited[x][y]
}
