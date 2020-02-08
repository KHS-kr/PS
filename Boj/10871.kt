import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var a = scanner.nextInt()
    var b = scanner.nextInt()
    var list = ArrayList<Int>()

    for(i in 1..a)
        list.add(scanner.nextInt())

    for(n in list) {
        if(b > n)
            print("$n ")
    }
}
