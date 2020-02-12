import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    var arr = Array(N) { Time(0, 0) }

    for(i in 0 until N) {
        val start = sc.nextInt()
        val end = sc.nextInt()

        arr[i] = Time(start, end)
    }
    var retval = 0
    arr.sortWith(Comparator { o1, o2 ->
        if(o1.end == o2.end)
            o1.start.compareTo(o2.start)
        else
            o1.end.compareTo(o2.end)
    })
    var curend = -1
    for(t in arr) {
        if(curend <= t.start) {
            curend = t.end
            retval++
        }
    }

    println(retval)
}

data class Time(var start : Int, var end : Int)
