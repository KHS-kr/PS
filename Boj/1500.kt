import java.util.*

var S = 0; var K = 0

fun main() = with(Scanner(System.`in`)) {
    S = nextInt()
    K = nextInt()

    val arr = IntArray(K) { S / K }
    var ret = 1L
    var temp = S - (S / K) * K

    var i = 0
    while(temp != 0) {
        arr[i++]++
        temp--
    }

    for(i in arr)
        ret *= i

    println(ret)
}
