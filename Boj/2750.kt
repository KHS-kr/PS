import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()
    sc.nextLine()

    var arr = ArrayList<Int>()

    for(i in 0 until N)
        arr.add(sc.nextInt())

    arr.sort()
    
    for(i in arr)
        println(i)
}
