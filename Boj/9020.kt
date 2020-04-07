import java.util.*

val arr = BooleanArray(10001) { true }

fun main() = with(Scanner(System .`in`)) {
    arr[0] = false; arr[1] = false
    var i = 2
    while(i * i < 10000) {
        if(arr[i])
            for(j in (i * i..10000) step i)
                arr[j] = false
        i++
    }

    repeat(nextInt()) {
        nextInt().goldbach()
    }
}

fun Int.goldbach() {
    for(i in (1..this / 2).reversed())
        if(arr[i] && arr[this - i]) {
            println("$i ${this - i}")
            return
        }
}
