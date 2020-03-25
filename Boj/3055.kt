import java.util.*

var R = 0; var C = 0
//lateinit var arr : Array<CharArray>
val arr = Array(50) { CharArray(50) }
val cache = Array(50) { IntArray(50) }
lateinit var S : Pair<Int, Int>
lateinit var D : Pair<Int, Int>
val move = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
val water : Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

fun main() = with(Scanner(System.`in`)) {
    R = nextInt()
    C = nextInt()
    nextLine()
    for(i in 0 until R) {
        val temp = nextLine()
        for(j in 0 until C)
            arr[i][j] = temp[j]
    }

    out@for(a in arr.indices)
        for(b in arr[a].indices) {
            when(arr[a][b]) {
                'S' -> S = Pair(a, b)
                'D' -> D = Pair(a, b)
                '*' -> water.add(Pair(a, b))
            }
        }

    val ret = BFS()
    println(if(ret == -1) "KAKTUS" else ret)
}

fun BFS() : Int{
    val mole : Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    mole.add(S)
    cache[S.first][S.second] = 1

    while(!mole.isEmpty()) {
        val waterSize = water.size

        for(j in 0 until waterSize) {
            val cur = water.poll()
            for(k in 0 until 4) {
                val tx = cur.first + move[k].first
                val ty = cur.second + move[k].second

                if(tx in 0 until R && ty in 0 until C) {
                    if(arr[tx][ty] == '.') {
                        arr[tx][ty] = '*'
                        water.add(Pair(tx, ty))
                    }
                }
            }
        }

        val curSize = mole.size
        for(i in 0 until curSize) {
            val cur = mole.poll()
            if(cur.first == D.first && cur.second == D.second)
                return cache[cur.first][cur.second] - 1

            for(j in 0 until 4) {
                val tx = cur.first + move[j].first
                val ty = cur.second + move[j].second

                if(tx in 0 until R && ty in 0 until C) {
                    if(arr[tx][ty] != '*' && arr[tx][ty] != 'X' && cache[tx][ty] == 0) {
                        cache[tx][ty] = cache[cur.first][cur.second] + 1
                        mole.add(Pair(tx, ty))
                    }
                }
            }

        }
    }

    return -1
}
