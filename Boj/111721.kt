import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextLine()

    A.allsum()
}

fun String.allsum(){
    var count = 0
    for(c in this.indices) {
        if(count >= 10) {
            println()
            count = 0
        }
        print(this[c])
        count++
    }
}
