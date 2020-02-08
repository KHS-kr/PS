import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var shorts = Array(9) { 0 }

    for(i in shorts.indices)
        shorts[i] = sc.nextInt()

    val sum = shorts.sum()
    var not = arrayOf<Int>()
    shorts = shorts.sorted().toTypedArray()

    out@for(i in 0 until shorts.size - 1) {
        for(j in i + 1 until shorts.size) {
            if(sum - shorts[i] - shorts[j] == 100) {
                not += i; not += j
                break@out
            }
        }
    }
    for(i in shorts.indices)
        if(!not.contains(i))
            println(shorts[i])
}
