import java.util.*

var n = 0; var k = 0
lateinit var arr : IntArray
lateinit var dp : IntArray

fun main() = with(Scanner(System.`in`)) {
    n = nextInt(); k = nextInt()

    arr = IntArray(n) { nextInt() }
    dp = IntArray(k + 1)
    dp[0] = 1

    for(i in 0 until n)
        for(j in arr[i]..k)
            if(j - arr[i] >= 0)
                dp[j] += dp[j - arr[i]]

    println(dp[k])
}
