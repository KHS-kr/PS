import java.util.*

lateinit var temp : Array<Int>
lateinit var visited : Array<Boolean>
var N = 0; var M = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()

    temp = Array(M) { 0 }
    visited = Array(N) { false }

    dfs(0)
}

fun dfs(n : Int) {
    if(n == M) {
        for(i in temp)
            print("$i ")
        println()
    }
    else {
        for(i in 1..N) {
            if(!visited[i - 1]) {
                visited[i - 1] = true
                temp[n] = i
                dfs(n + 1)
                visited[i - 1] = false
            }
        }
    }
}
