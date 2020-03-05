import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val ret = Array(N) { 0 }

    for(i in 0 until N) {
        var left = sc.nextInt()
        for(j in ret.indices) {
            if (left == 0 && ret[j] == 0) {
                ret[j] = i + 1
                break
            }
            else if(ret[j] == 0)
                left--
        }
    }

    for(i in ret)
        print("$i ")
}
