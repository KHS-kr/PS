import java.util.*

val arr = Array(2_000_001) { true }

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    arr[1] = false
    var i = 2
    while(i * i <= 2_000_000) {
        if(arr[i]) {
            var j = i * i
            while(j <= 2_000_000) {
                arr[j] = false
                j += i
            }
        }
        i++
    }

    for(i in N..2_000_000)
        if(arr[i])
            if(falindrom(i)) {
                println(i)
                return@with
            }
}

fun falindrom(n : Int) : Boolean {
    val str = n.toString()
    val mid = (str.length / 2) - 1
    for(i in 0..mid)
        if(str[i] != str[str.length - i - 1])
            return false
    return true
}
