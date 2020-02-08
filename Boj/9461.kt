import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)
    var N = sc.nextInt()
    sc.nextLine()

    val dp = Array(100) {0L}

    dp[0] = 1; dp[1] = 1; dp[2] = 1
    for(i in 0 until N) {
        var T = sc.nextLine().toInt()
        for (i in 3 until T) {
            if(dp[i] == 0L) {
                dp[i] = dp[i - 3] + dp[i - 2]
            }
        }
        println(dp[T - 1])
    }
}
