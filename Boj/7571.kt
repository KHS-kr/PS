import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt() //행, 열의 크기
    val M = sc.nextInt() //점의 갯수

    var xArr = Array(M) { 0 }
    var yArr = Array(M) { 0 }

    for(i in 0 until M) {
        xArr[i] = sc.nextInt()
        yArr[i] = sc.nextInt()
    }

    xArr.sort(); yArr.sort()
    var x = xArr[M / 2]; var y = yArr[M / 2]

    var ret = 0

    for(i in 0 until M)
        ret += abs(xArr[i] - x) + abs(yArr[i] - y)

    println(ret)
}
