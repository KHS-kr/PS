import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()

    var arr = Array(N) { Array<Char>(N) { '_' } }

    for(i in 0 until N) {
        val temp = sc.nextLine()
        for(j in 0 until N) {
            arr[i][j] = temp[j]
        }
    }

    var retval = 0

    for(i in 0 until N) {
        for(j in 0 until N - 1) {
            if(arr[i][j] == arr[i][j + 1])
                continue
            val temp = arr[i][j]
            arr[i][j] = arr[i][j + 1]
            arr[i][j + 1] = temp
            retval = retval max arr.Bomboni()
            arr[i][j + 1] = arr[i][j]
            arr[i][j] = temp
        }
    }

    for(i in 0 until N) {
        for(j in 0 until N - 1) {
            if(arr[j][i] == arr[j + 1][i])
                continue
            val temp = arr[j][i]
            arr[j][i] = arr[j + 1][i]
            arr[j + 1][i] = temp
            retval = retval max arr.Bomboni()
            arr[j + 1][i] = arr[j][i]
            arr[j][i] = temp
        }
    }

    println(retval)
}

fun Array<Array<Char>>.Bomboni() : Int {
    var retval = 0

    for(i in this.indices) {
        var countX = 0; var countY = 0
        var prevX = '_'; var prevY = '_'
        for(j in this.indices) {
            if(prevX != this[i][j]) {
                retval = retval max countX
                countX = 1
                prevX = this[i][j]
            }
            else
                countX++

            if(prevY != this[j][i]) {
                retval = retval max countY
                countY = 1
                prevY = this[j][i]
            }
            else countY++
        }
        retval = (countX max countY) max retval
    }

    return retval
}

infix fun Int.max(other : Int) = if(this > other) this else other
