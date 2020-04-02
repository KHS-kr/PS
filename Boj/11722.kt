import java.util.*

var N = 0
lateinit var arr : IntArray
val dp = IntArray(1000) { 1 }

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    arr = IntArray(N) { nextInt() }

    var ret = 0

    for(i in 0 until N) {
        var min = 0
        for(j in 0 until i) {
            if(arr[i] < arr[j])
                if(min < dp[j])
                    min = dp[j]
        }
        dp[i] = min + 1
        if(ret < dp[i])
            ret = dp[i]
    }

    println(ret)
}
