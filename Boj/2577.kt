import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var a = scanner.nextInt()
    var b = scanner.nextInt()
    var c = scanner.nextInt()
    var m = a * b * c

    var array : Array<Int> = Array(10, {0})

    count(array, m)
    for(i in array)
        println(i)
}

fun count(arr : Array<Int>, sum : Int) {

    for(i in sum.toString())
        arr[i.toInt() - 48]++
}
