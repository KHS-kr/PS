import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)
    var N = sc.nextInt()

    val dp = Array(N + 1) {0}

    dp[0] = 1
    dp[1] = 1

    for(i in 0..N) {
        if(dp[i] == 0)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }
    println(dp[N])
}
