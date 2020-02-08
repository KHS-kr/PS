import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var str = scanner.nextLine()
    var token = StringTokenizer(str, " ")
    
    print(token.countTokens())
}
