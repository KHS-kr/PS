import java.util.*
import kotlin.math.max

var astr = ""; var bstr = ""

fun main() = with(Scanner(System.`in`)) {
    astr = nextLine()
    bstr = nextLine()

    val dp = Array(astr.length + 1) { IntArray(bstr.length + 1) }

    for(i in 1..astr.length) {
        for(j in 1..bstr.length) {
            if(astr[i - 1] == bstr[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
            else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        }
    }

    println(dp[astr.length][bstr.length])
}
