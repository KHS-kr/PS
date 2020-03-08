import java.util.*

lateinit var temp : Array<Int>
lateinit var input : Array<Int>
lateinit var visited : Array<Boolean>
lateinit var depth : Array<Int>
var N = 0; var M = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    input = Array(N) { sc.nextInt() }
    input.sort()
    visited = Array(input.size) { false }
    temp = Array(M) { 0 }
    dfs(0)
}

fun dfs(n : Int) {
    if(n == M) {
        for(i in temp)
            print("$i ")
        println()
    }
    else {
        var before = -1
        for(i in input.indices) {
            if(!visited[i] && before != input[i]) {
                before = input[i]
                visited[i] = true
                temp[n] = input[i]
                dfs(n + 1)
                visited[i] = false
            }
        }
    }
}

fun Array<Int>.toPrint() : String {
    var retval = ""
    for(i in this)
        retval += "$i "

    return retval
}
