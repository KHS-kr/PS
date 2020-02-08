import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var a = scanner.nextInt()
    var b = scanner.nextInt()
    var c = scanner.nextInt()
    
    var s = listOf(a, b, c)
    print(s.sorted()[1])
}
