import java.util.*
import kotlin.math.max
import kotlin.math.min

var N = 0
//친구 관계 나타내기 위한 배열
val arr = Array(51) { IntArray(51 ) { 100 } }

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    var t1 = nextInt()
    var t2 = nextInt()
    while(t1 != -1 || t2 != -1) {
        arr[t1][t2] = 1
        arr[t2][t1] = 1
        t1 = nextInt()
        t2 = nextInt()
    }

    for(i in 1..N)
        for(j in 1..N)
            for(k in 1..N)
                if(arr[j][k] > arr[j][i] + arr[i][k])
                    arr[j][k] = arr[j][i] + arr[i][k]

    val points = IntArray(N)
    for(i in 1..N)
        for(j in 1..N) {
            if(i == j)
                continue
            points[i - 1] = max(points[i - 1], arr[i][j])
        }

    val min = points.min()!!
    var ret = intArrayOf()

    for(p in points.indices)
        if(points[p] == min) {
            ret += p + 1
        }

    println("$min ${ret.size}")
    for(i in ret)
        print("$i ")
}
