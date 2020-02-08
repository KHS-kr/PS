import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var arr = ArrayList<Int>()

    for(i in 0 until 9) {
        var temp = sc.nextInt()
        arr.add(temp)
    }

    println(arr.max())
    println(arr.indexOf(arr.max()) + 1)
}
