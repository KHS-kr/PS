import java.util.*

lateinit var arr : Array<Array<Int>>
var M = 0
var N = 0

var retval = false
fun main() {
    val sc = Scanner(System.`in`)
    val temp = sc.nextLine().split(" ")
    M = temp[0].toInt()
    N = temp[1].toInt()

    arr = Array(M) { Array(N) { 0 } }
    for(i in 0 until M) {
        val input = sc.nextLine()
        for(j in 0 until N)
            arr[i][j] = input[j].toString().toInt()
    }

    for(i in 0 until N) {
        if(arr[0][i] == 0)
            find(0, i)
    }

    println(if(retval) "YES" else "NO")
}

fun find(x : Int, y : Int) {
    arr[x][y] = 1
    if(x == M - 1)
        retval = true

    if(x > 0 && arr[x - 1][y] == 0)
        find(x - 1, y)
    if(y > 0 && arr[x][y - 1] == 0)
        find(x, y - 1)
    if(x < M - 1 && arr[x + 1][y] == 0)
        find(x + 1, y)
    if(y < N - 1 && arr[x][y + 1] == 0)
        find(x, y + 1)
}
