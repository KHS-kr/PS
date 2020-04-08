import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var M = 0; var N = 0
lateinit var arr : Array<IntArray>
val visited = Array(101) { Array(101) { BooleanArray(5) } }
lateinit var start : Robot
lateinit var target : Robot
val dir = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
val queue : Queue<Robot> = LinkedList()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var temp = readLine().split(" ")
    M = temp[0].toInt(); N = temp[1].toInt()

    arr = Array(M + 2) { IntArray(N + 2) { 1 } }
    for(i in 1..M) {
        temp = readLine().split(" ")
        for(j in 1..N)
            arr[i][j] = temp[j - 1].toInt()
    }
    temp = readLine().split(" ")
    start = Robot(temp[1].toInt(), temp[0].toInt(), temp[2].toInt())
    temp = readLine().split(" ")
    target = Robot(temp[1].toInt(), temp[0].toInt(), temp[2].toInt())

    move()
}

fun move() {
    queue.add(start)

    while(queue.isNotEmpty()) {
        val now = queue.poll()
        val x = now.x
        val y = now.y
        val cnt = now.count
        val nsew = now.nsew

        if(x == target.x && y == target.y && nsew == target.nsew) {
            println(cnt)
            return
        }

        //1~3 이동
        for(i in 1..3) {
            val tx = dir[nsew - 1].first * i + x
            val ty = dir[nsew - 1].second * i + y

            if(tx in 1..N && ty in 1..M) {
                if(arr[ty][tx] == 0) {
                    if(!visited[ty][tx][nsew]) {
                        visited[ty][tx][nsew] = true
                        queue.add(Robot(tx, ty, nsew, cnt + 1))
                    }
                }
                else
                    break
            }
        }
        //회전
        for(i in 1..4) {
            if(nsew != i && !visited[y][x][i]) {
                var add = 1
                if(nsew == 1) {
                    if (i == 2) add++
                }
                else if(nsew == 2) {
                    if (i == 1) add++
                }
                else if(nsew == 3) {
                    if(i == 4) add++
                }
                else {
                    if(i == 3) add++
                }
                visited[y][x][i] = true
                queue.add(Robot(x, y, i, cnt + add))
            }
        }
    }
}

data class Robot(var x : Int, var y : Int, var nsew : Int, var count : Int = 0)
