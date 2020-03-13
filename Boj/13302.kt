import java.util.*
import kotlin.math.min

var arr = Array(111) { true }
var dp = Array(111) { Array(111) { 0 } }
var N = 0; var M = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    for(i in 0 until M) {
        val temp = sc.nextInt()
        arr[temp] = false
    }

    println(resort(1, 0, 0))
}

fun resort(day : Int, coupon : Int, money : Int) : Int {
    if(N < day) return money
    if(dp[day][coupon] != 0) return dp[day][coupon] + money
    if(!arr[day]) return resort(day + 1, coupon, money)

    var retval = min(resort(day + 1, coupon, money + 10000), //1일권
        min(resort(day + 3, coupon + 1, money + 25000), //3일권
            resort(day + 5, coupon + 2, money + 37000)))

    if(coupon >= 3)
        retval = min(retval, resort(day + 1, coupon - 3, money))

    dp[day][coupon] = retval - money

    return retval
}
