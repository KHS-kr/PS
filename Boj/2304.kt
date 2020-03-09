import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val arr = Array(N) { graph(sc.nextInt(), sc.nextInt()) }
    arr.sortBy { it.L }
    var ret = 0
    val max = arr.maxBy { it.H }!!
    var maxIdx = -1
    for(i in arr.indices) {
        if (arr[i].H == max.H) {
            maxIdx = i
        }
    }

    var prev = arr[0]
    for(i in 1..maxIdx) {
        if (prev.H <= arr[i].H) {
            ret += (arr[i].L - prev.L) * prev.H
            prev = arr[i]
        }
    }

    prev = arr[N - 1]
    for(i in (maxIdx..(N - 2)).reversed()) {
        if (prev.H <= arr[i].H) {
            ret += (prev.L - arr[i].L) * prev.H
            prev = arr[i]
        }
    }

    ret += max.H
    println(ret)
}

data class graph(val L : Int, val H : Int)
