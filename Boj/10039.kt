import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
//    var input = scanner.nextLine().toInt()
    
    var sum = 0
    
    for(i in 1..5) {
        var a = scanner.nextLine().toInt()
        sum += if(a > 40) a else 40
    }
    
    print(sum / 5)
}
