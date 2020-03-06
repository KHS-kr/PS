import java.util.*

lateinit var temp : Array<Int>
lateinit var visited : Array<Boolean>
lateinit var arr : Array<Int>
var N = 0; var M = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    arr = Array(N) { sc.nextInt() }
    arr.sort()
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
        for(i in 0 until N) {
            if(n != 0 && temp[n - 1] > arr[i])
                continue
            if(!visited[i]) {
                visited[i] = true
                temp[n] = arr[i]
                dfs(n + 1)
                visited[i] = false
            }
        }
    }
}
