import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()

    var br = false
    var count = 1

    while(!br) {
        if(count.Bulzip() >= N)
            br = true
        count++
    }
    println(count - 1)
}

fun Int.Bulzip() = 3 * this * this - 3 * this + 1
