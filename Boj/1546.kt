import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var N = scanner.nextLine().toInt()
    var list = ArrayList<Int>()

    for(i in 1..N)
        list.add(scanner.nextInt())

    var m = list.max()
    var average : Double = 0.0
    for(n in list)
        average += (n.toDouble() / m!! * 100)
    print(average/N)
}
