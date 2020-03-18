import java.util.*

var R = 0; var C = 0; var N = 0
lateinit var arr : Array<Array<Char>>
var time = 2

fun main() {
    val sc = Scanner(System.`in`)
    val temp = sc.nextLine().split(" ")
    R = temp[0].toInt()
    C = temp[1].toInt()
    N = temp[2].toInt()

    arr = Array(R) { Array(C) { '.' } }
    for(a in arr.indices) {
        val temp = sc.nextLine()
        for(b in arr[a].indices)
            arr[a][b] = temp[b]
    }

    bomberman()
    for(a in arr) {
        for(b in a)
            print(b)
        println()
    }
    println()
}

fun bomberman() {
    val bombs = Array(40000) { Bomb(-1, -1)}
    var pointer = 0
    while(time <= N) {
        if(time % 2 == 0) {
            for (i in arr.indices)
                for (j in arr[i].indices)
                    if(arr[i][j] == 'O') {
//                        bombs.add(bomb(i, j))
                        bombs[pointer] = Bomb(i, j)
                        pointer++
                    }
            for(i in arr.indices)
                for(j in arr[i].indices)
                    arr[i][j] = 'O'
        }
        else {
            for(b in 0 until pointer) {
                val i = bombs[b].x
                val j = bombs[b].y

                arr[i][j] = '.'
                if (i != 0)
                    arr[i - 1][j] = '.'
                if (i != R - 1)
                    arr[i + 1][j] = '.'
                if (j != 0)
                    arr[i][j - 1] = '.'
                if (j != C - 1)
                    arr[i][j + 1] = '.'
            }
            pointer = 0
        }
        time++
    }
}

data class Bomb(val x : Int, val y : Int)
