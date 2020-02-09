import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var L = -1
    var P = -1
    var V = -1
    var i = 0

    while(true) {
        L = sc.nextInt()
        P = sc.nextInt()
        V = sc.nextInt()

        if(L == 0 && P == 0 && V == 0) break

        i++
        val ret = (V / P) * L + if(V % P > L) L else V % P
        println("Case $i: $ret")
    }

}
