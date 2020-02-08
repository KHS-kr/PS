import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()

    for(i in 0 until N) {
        var M = sc.nextInt()
        var arr = ArrayList<Int>()
        for(j in 0 until M) {
            arr.add(sc.nextInt())
        }

        var count = 0
        var average = arr.sum() / M.toDouble()
        for(c in arr)
            if(c.toDouble() > average)
                count++

//        println(((count / M) * 100 * 1000).toDouble().sosu3())
        System.`out`.printf("%.3f%%\n", (count / M.toDouble()) * 100)
    }
}

fun ArrayList<Int>.sum() : Int {
    var sum = 0
    for(n in this)
        sum += n
    return sum
}
