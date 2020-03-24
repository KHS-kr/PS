import java.util.*
import kotlin.system.exitProcess

lateinit var arr : Array<IntArray>
lateinit var visited : Array<BooleanArray>
var now = 0; var prev = 0
var y = 0; var x = 0
val search = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

fun main() = with(Scanner(System .`in`)) {
    y = nextInt()
    x = nextInt()
    arr = Array(y) { IntArray(x) { nextInt() } }

    for(a in arr)
        for(i in a)
            if(i == 1)
                now++

//    cheese(1)
    var time = 0
    while(!zerocheck()) {
        prev = now
        time++
        visited = Array(y) { BooleanArray(x) { false } }
        insertC(0, 0)

        for(i in 0 until y) {
            for(j in 0 until x) {
                if(arr[i][j] == 1) {
                    for(s in search) {
                        val a = i + s.first
                        val b = j + s.second
                        if(a in 0 until y && b in 0 until x) {
                            if (arr[a][b] == -1) {
                                arr[i][j] = 0
                                now--
                                break
                            }
                        }
                    }
                }
            }
        }
    }

    println(time)
    println(prev)
}

//-1은 공기
fun insertC(a : Int, b : Int) {
    for(s in search) {
        val aa = a + s.first
        val bb = b + s.second
        if(aa in 0 until y && bb in 0 until x) {
            if(arr[aa][bb] != 1 && !visited[aa][bb]) {
                arr[aa][bb] = -1
                visited[aa][bb] = true
                insertC(aa, bb)
            }
        }
    }
}

//true == 모두가 다 0임
fun zerocheck() : Boolean {
    for(a in arr) {
        for(i in a)
            if(i == 1)
                return false
    }
    return true
}
