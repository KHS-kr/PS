import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt()
    for(i in 0 until T) {
        val N = sc.nextInt()
        val arr = Array(N) { sc.nextInt() }.sorted().reversed()
        println(func(arr))
    }
}

fun func(arr : List<Int>) : Int {
    val temp = Array(arr.size) { 0 }
    val mid = arr.size / 2
    temp[mid] = arr[0]
    var flag = true
    var size = 1

    for(i in 1 until arr.size) {
        if(flag) { //왼쪽
            temp[mid - size] = arr[i]
            flag = false
        }
        else { //오른쪽
            temp[mid + size] = arr[i]
            flag = true
            size++
        }
    }

    var max = 0
    for(i in 0 until temp.size - 1)
        max = kotlin.math.max(max, abs(temp[i + 1] - temp[i]))

    return max
}
