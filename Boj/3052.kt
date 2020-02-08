import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var arr = ArrayList<Int>()

    for(i in 0 until 10) {
        var temp = sc.nextInt()
        temp %= 42
        arr.add(temp)
    }

    println(arr.toSet().size)
}
