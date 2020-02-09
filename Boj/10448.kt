import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()
    val arr = Array(N) { 0 }

    for(i in arr.indices)
        arr[i] = sc.nextLine().toInt()

    //1000보다 작은 삼각수 미리 계산
    var e = 1
    var eureka = arrayOf<Int>()
    while(true) {
        val temp = e * (e + 1) / 2
        if(temp >= 1000)
            break

        eureka += temp
        e++
    }

    out@for(score in arr) {
        for(i in eureka) {
            for(j in eureka) {
                for(k in eureka) {
                    if(score == i + j + k) {
                        println(1)
                        continue@out
                    }
                }
            }
        }
        println(0)
    }

}
