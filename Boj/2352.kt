import java.util.*

var N = 0
val arr = IntArray(1_000_000)

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()

    var len = 0; var temp = 0; var cnt = 0
    arr[len] = Int.MIN_VALUE

    for(i in 0 until N) {
        temp = nextInt()
        if(temp >= arr[len]) {
            arr[++len] = temp
            cnt++
        }
        else {
            val lb = lower_bound(len, temp)
            arr[lb] = temp
        }
    }

    println(cnt)
}

fun lower_bound(end : Int, n : Int) : Int {
    var left = 1
    var right = end

    while(left < right) {
        val mid = (left + right) / 2
        if(mid == right)
            return right
        if(arr[mid] < n)
            left = mid + 1
        else
            right = mid
    }
    return left
}
