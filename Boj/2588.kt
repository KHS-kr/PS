import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var first = sc.nextInt()
    sc.nextLine()
    var second = sc.nextInt()

    println(first * (second % 10))
    println(first * ((second / 10) % 10))
    println(first * (second / 100))
    println(first * second)
}
