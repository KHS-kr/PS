import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    val arr = Array(K) { 0 }
    for(i in 0 until K)
        arr[i] = sc.nextInt()
    val multi = Array(N) { -1 }
    var target = 0
    var count = 0
    re1@for(i in arr.indices) {
        //빈 콘센트 찾기
        for(t in multi.indices) {
            if (multi[t] == -1 || multi[t] == arr[i]) {
                multi[t] = arr[i]
                continue@re1
            }
        }
        //이후에 안나오는거 지우거나 최소횟수로 나오는거 뻄
        var temp = -1
        for(j in 0 until N) {
            var last = 0
            for(k in i + 1 until K) {
                if(multi[j] == arr[k])
                    break
                last++
            }
            if(last > temp) {
                target = j
                temp = last
            }
        }
        multi[target] = arr[i]
        count++
    }
    println(count)
}
