import java.util.*
import kotlin.math.max

lateinit var arr : Array<IntArray>
lateinit var dp : Array<IntArray>
var N = 0

fun main() = with(Scanner(System .`in`)) {
    val T = nextInt()
    repeat(T) {
        N = nextInt()
        arr = Array(2) { IntArray(N) }
        repeat(2) {
            for (i in 0 until N)
                arr[it][i] = nextInt()
        }

        //0 : 왼쪽 아무것도 안뗌, 1 : 왼쪽 위 뗌, 2 : 왼쪽 아래 뗌
        dp = Array(3) { IntArray(N) { -1 } }
//        dp[0][0] = 0; dp[1][0] = 0; dp[2][0] = 0

        println(sticker(0, 0))
    }
}

fun sticker(n : Int, status : Int) : Int {
    if(n >= N) return 0
    if(dp[status][n] != -1) return dp[status][n]

    var result = sticker(n + 1, 0)
    if(status != 1) result = max(result, sticker(n + 1, 1) + arr[0][n])
    if(status != 2) result = max(result, sticker(n + 1, 2) + arr[1][n])

    dp[status][n] = result
    return result
}
