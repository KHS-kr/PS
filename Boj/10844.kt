import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var N = sc.nextInt()

    val dp = Array(N) { i ->  Array(11) { if(i == 0) 1L else 0L } }
    dp[0][0] = 0; dp[0][10] = 0
    for(i in 1 until N) {
        dp[i][0] = dp[i - 1][1]
        for(j in 1..9) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000
        }
    }

    println(arrSum(dp, N))
}

fun arrSum(arr : Array<Array<Long>>, N : Int) : Int {
    var sum = 0L
    for(i in 0..9)
        sum += arr[N - 1][i]

    return (sum % 1_000_000_000).toInt()
}
