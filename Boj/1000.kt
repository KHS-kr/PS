import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()
    var B = scanner.nextInt()
    
    print(A plus B)
}

//infix fun Int.plus(other : Int) = this + other
infix fun Int.plus(other : Int): Int {
    return this + other
}
