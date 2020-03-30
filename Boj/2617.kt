import java.util.*

var N = 0; var M = 0
lateinit var arr : Array<Pair<Int, Int>>
val big = IntArray(100)
val small = IntArray(100)
val bigbig = Array(100) { BooleanArray(100) }
val smallsmall = Array(100) { BooleanArray(100) }
val visited = BooleanArray(100)

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    M = nextInt()

    arr = Array(M) { Pair(nextInt(), nextInt()) }

    for(a in arr) {
        bigbig[a.second][a.first] = true
        smallsmall[a.first][a.second] = true
    }

    val mid = (N + 1) / 2
    for(i in 1..N) {
        bigDFS(i, i)
        visited.clear()
        smallDFS(i, i)
        visited.clear()
    }
    var ret = 0
    for(i in 1..N) {
        ret += if(small[i] >= mid) 1 else 0
        ret += if(big[i] >= mid) 1 else 0
    }

    println(ret)
}

fun BooleanArray.clear() {
    for(i in this.indices)
        this[i] = false
}

fun bigDFS(p : Int, n : Int) {
    visited[n] = true
    for(i in 1..N) {
        if(bigbig[n][i] && !visited[i]) {
            big[p]++
            bigDFS(p, i)
        }
    }
}

fun smallDFS(p : Int, n : Int) {
    visited[n] = true
    for(i in 1..N) {
        if(smallsmall[n][i] && !visited[i]) {
            small[p]++
            smallDFS(p, i)
        }
    }
}
