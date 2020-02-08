import java.util.*

val dp = Array(91) {0L}

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)
    var N = sc.nextInt()

    dp[1] = 1
    dp[2] = 1

    for(i in 1..N) {
        if(dp[i] == 0L)
            dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[N])
}
