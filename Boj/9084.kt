import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val T = sc.nextLine().toInt()

    for(i in 0 until T) {
        val N = sc.nextLine().toInt()
        val temp = sc.nextLine().split(" ")
        val money = Array(N + 1) { i -> if(i == 0) 0 else temp[i - 1].toInt() }
        val target = sc.nextLine().toInt()

        val dp = Array(target + 1) { 0 }
        dp[0] = 1
        for(i in 1..N) {
            for(j in money[i]..target) {
                dp[j] += dp[j - money[i]]
            }
        }

        println(dp[target])
    }
}
