import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    val arr = Array(N) { 0 }
    for(i in 0 until N)
        arr[i] = sc.nextInt()
    arr.sort()
    val dis = MutableList(N - 1) { i -> arr[i + 1] - arr[i] }
    dis.sort()
    for(i in 0 until K - 1) {
        if(dis.size == 0)
            break
        dis.removeAt(dis.size - 1)
    }
    
    var retval = 0
    for(i in dis)
        retval += i
    println(retval)
}
