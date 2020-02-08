import java.util.*

fun main(array : Array<String>) {
    dp[0] = 0
    dp[1] = 1
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    
    print(pizza(n))
}

var dp = IntArray(10) {-1}

fun pizza(N : Int) : Int {
    if(dp[N - 1] == -1) {
        var a = N / 2
        var b = if (N % 2 == 0) N / 2
        else
            (N / 2) + 1

        dp[N - 1] = a * b + pizza(a) + pizza(b)
    }

    return dp[N - 1]
}
