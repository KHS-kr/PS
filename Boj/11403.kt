import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()

    val arr = Array(N) { Array(N) { 0 } }

    for(i in 0 until N) {
        for(j in 0 until N) {
            arr[i][j] = sc.nextInt()
        }
    }

    for(k in 0 until N) {
        for(i in 0 until N) {
            for(j in 0 until N) {
                if(arr[i][k] == 1 && arr[k][j] == 1)
                    arr[i][j] = 1
            }
        }
    }

    for(i in arr) {
        for(j in i)
            print("$j ")
        println()
    }
}
