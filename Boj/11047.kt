import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    val K = sc.nextInt()

    var arr = arrayOf<Int>()

    for(i in 0 until N)
        arr += sc.nextInt()

    arr.reverse()

    var count = 0; var now = K
    var i = -1
    while(now != 0) {
        i++
        if(now < arr[i])
            continue
        count += now / arr[i]
        now %= arr[i]
    }

    println(count)
}
