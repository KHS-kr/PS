import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    var arr = Array(N) { Time(0, 0) }
    for(i in 0 until N)
        arr[i] = Time(sc.nextInt(), sc.nextInt())

    arr.sortBy { it.start }

    val q = PriorityQueue<Int>()
    q.offer(arr[0].end)
    out@for(i in 1 until N) {
        if(q.peek() > arr[i].start)
            q.offer(arr[i].end)
        else {
            q.poll()
            q.offer(arr[i].end)
        }
    }

    println(q.size)
}

data class Time(var start : Int, var end : Int)
