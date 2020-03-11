import java.util.*

lateinit var arr : Array<Boolean>
fun main() {
    val sc = Scanner(System.`in`)
    val M = sc.nextInt()
    val N = sc.nextInt()
    arr = Array(N + 1) { true }
    arr[1] = false

    for(i in 2..N) {
        if(!arr[i])
            continue
        var temp = 2
        while(temp * i <= N) {
            arr[temp * i] = false
            temp++
        }
    }

    for(i in M..N) {
        if(arr[i])
            println(i)
    }
}
