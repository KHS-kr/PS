import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()
    var B = scanner.nextInt()
    var C = scanner.nextInt()

    println((A + B) % C)
    println((A % C + B % C) % C)
    println((A * B) % C)
    println(((A % C) * (B % C)) % C)
}
