import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var n = scanner.nextLine().toInt()

    for(i in 1..n)
        println(scanner.nextLine().OXQuiz())
}

fun String.OXQuiz() : Int{
    var score = 0
    var count = 0

    for(c in this) {
        if(c == 'O') {
            count++
            score += count
        }
        else
            count = 0
    }

    return score
}
