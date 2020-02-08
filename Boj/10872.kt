import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()

    var ret = 1
    
    for(i in (1..N).reversed())
        ret *= i
    
    println(ret)
}
