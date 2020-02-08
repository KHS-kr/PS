import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)
    var N = sc.nextInt()
    sc.nextLine()
    var arr = Array(N + 1) { 0 }
    for(i in 0 until N)
        arr[i] = sc.nextLine().toInt()
    var dp = Array(N + 1) { 0 }

    dp[0] = arr[0]
    dp[1] = Math.max(arr[0] + arr[1], arr[1])
    dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2])
    for(i in 3 until N) {
        dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i])
    }
    println(dp[N - 1])
}
