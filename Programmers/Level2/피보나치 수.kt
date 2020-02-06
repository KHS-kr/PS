class Solution {
    val dp = Array(100001) { -1 }
    fun solution(n: Int): Int {
        dp[0] = 0
        dp[1] = 1
        return fibo(n)
    }
    fun fibo(n : Int) : Int {
        if(dp[n] == -1) {
            dp[n] = (fibo(n - 2) % 1234567 + fibo(n - 1) % 1234567) % 1234567
        }
        return dp[n]
    }
}
