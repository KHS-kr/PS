import java.util.*

var N = 0; var B = 0L
lateinit var arr : Array<IntArray>
lateinit var ret : Array<IntArray>

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    B = nextLong()

    arr = Array(N) { IntArray(N) { nextInt() } }
    ret = arr

    zegob(B)

    for(i in 0 until N)
        for(j in 0 until N)
            ret[i][j] %= 1000

    for(a in ret) {
        for(i in a)
            print("$i ")
        println()
    }
}

fun zegob(b : Long) {
    if(b <= 1L)
        return

    if(b % 2 == 0L) {
        ret = ret square arr
        arr = ret
        zegob(b / 2)
    }
    else {
        val temp = arr
        zegob(b - 1)
        ret = ret square temp
    }
}

infix fun Array<IntArray>.square(other : Array<IntArray>) : Array<IntArray> {
    val temp = Array(N) { IntArray(N) }
    for(i in 0 until N)
        for(j in 0 until N)
            for(k in 0 until N)
                temp[i][j] = (temp[i][j] + (this[i][k] * other[k][j]) % 1000 ) % 1000

    return temp
}
