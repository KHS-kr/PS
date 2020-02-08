import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()
    var M = sc.nextInt()
    sc.nextLine()

    var arr = Array(N){0}

    for(i in 0 until N) {
        var temp = sc.nextInt()
        arr[i] = temp
    }

    println(blackJack(arr, M))
}

fun blackJack(arr : Array<Int>, M : Int) : Int {
    var ret = 0

    for(i in 0..arr.size - 3) {
        for(j in i + 1..arr.size - 2) {
            for(k in j + 1 until arr.size) {
                var sum = arr[i] + arr[j] + arr[k]
                if(sum in (ret + 1)..M)
                    ret = sum
            }
        }
    }

    return ret
}
