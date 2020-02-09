import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()
    val arr = Array(1000) { false }

    for(i in 123..999) {
        arr[i] = i.isBbNumber()
    }

    for(i in 0 until N) {
        val num = sc.nextInt()
        val strike = sc.nextInt()
        val ball = sc.nextInt()
        for(j in 123..999) {
            if(arr[j]) {
                val target = num.toString()
                val temp = j.toString()
                var t_strike = 0
                var t_ball = 0
                for(x in 0 until 3) {
                    for(y in 0 until 3) {
                        if(x == y && target[x] == temp[y])
                            t_strike++
                        else if(x != y && target[x] == temp[y])
                            t_ball++
                    }
                }
                if(strike != t_strike || ball != t_ball)
                    arr[j] = false
            }
        }
    }

    var ret = 0
    for(i in 123..999)
        if(arr[i])
            ret++

    println(ret)
}

//숫자야구에 적합한 숫자인지 체
fun Int.isBbNumber() : Boolean {
    var arr = this.toString().toCharArray()
    if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2] ||
        arr[0] == '0' || arr[1] == '0' || arr[2] == '0')
        return false
    return true
}
