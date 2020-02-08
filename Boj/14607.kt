import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextLong()

    print(pizza2(n))
}

fun pizza2(N : Long) : Long {
    var ret : Long= 0
    for(i in 2..N) 
        ret += i - 1

    return ret
}
