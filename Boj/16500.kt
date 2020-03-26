import java.util.*

var str = ""
lateinit var arr : Array<String>
val dp = IntArray(101)
var N = 0

fun main() = with(Scanner(System .`in`)) {
    str = nextLine()
    N = nextLine().toInt()
    arr = Array(N) { nextLine() }

    println(search(0))
}

fun search(idx : Int) : Int {
    if(dp[idx] != 0) return dp[idx]
    if(idx == str.length) {
        dp[idx] = 1
        return dp[idx]
    }

    for(i in 0 until N) {
        if(idx + arr[i].length > str.length)
            continue
        var flag = false
        for(j in arr[i].indices) {
            if (arr[i][j] != str[idx + j])
                flag = true
        }

        if(!flag)
            dp[idx] = dp[idx] or search(idx + arr[i].length)
    }

    return dp[idx]
}
