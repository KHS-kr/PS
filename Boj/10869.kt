import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()
    var B = scanner.nextInt()

    A op B
}

//infix fun Int.plus(other : Int) = this + other
infix fun Int.op(other : Int) : Unit{
    println(this + other)
    println(this - other)
    println(this * other)
    println(this / other)
    println(this % other)
}
