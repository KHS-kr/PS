import java.util.*

val dp = Array(5001) { 0L }
fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    for(i in 0 until N) {
        val temp = sc.nextInt()
        println(if(temp % 2 == 0) ST(temp) else 0)
    }
}

fun ST(n : Int) : Long {
    if(n == 0) return 1
    else if(dp[n] > 0) return dp[n]

    for(i in (2..n) step 2) {
        dp[n] += ST(i - 2) * ST(n - i)
        dp[n] %= 1_000_000_007L
    }

    return dp[n]
}

/*
if n == 5000
2 4998
4 4996
...
5000 0
 */
