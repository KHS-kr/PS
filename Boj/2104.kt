import java.util.*
import kotlin.math.max
import kotlin.math.min

val arr = Array(1000001) { 0 }

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    for(i in 1..N)
        arr[i] = sc.nextInt()
    
    println(divide_conquer(0, N))
}

fun divide_conquer(start : Int, end : Int) : Long {
    if(start == end) return arr[start] * arr[start].toLong()
    val mid = (start + end) / 2
    val leftSum = divide_conquer(start, mid)
    val rightSum = divide_conquer(mid + 1, end)

    var maxval = max(leftSum, rightSum)
    var left = mid; var right = mid + 1

    var sum = arr[left] + arr[right]
    var minval = min(arr[left], arr[right]).toLong()
    maxval = max(maxval, sum * minval.toLong())

    while(left > start || right < end) {
        if(right < end && (left == start || arr[left - 1] < arr[right + 1])) {
            right++
            sum += arr[right]
            minval = min(minval, arr[right].toLong())
        }
        else {
            left--
            sum += arr[left]
            minval = min(minval, arr[left].toLong())
        }
        var temp = sum * minval
        maxval = max(maxval, temp)
    }

    return maxval
}
// 참고 : https://yangorithm.tistory.com/51
// 아래 코드 : 풀이 참조 전 작성한 코드, 시간도 오래걸리고 원하는 결과값이 안나옴

//fun divide_conquer(start : Int, end : Int) : Long {
//    if(start == end - 1) return arr[start] * arr[start].toLong()
//
//    val mid = (start + end) / 2
//    val leftval = divide_conquer(start, mid)
//    val rightval = divide_conquer(mid, end)
//    var retval = max(leftval, rightval)
//
//    var left = mid; var right = mid
////    val midval = arr.calc(left, right)
////    retval = max(retval, midval)
//
//    while(left > start && right < end) {
//        val lval = arr.calc(left - 1, right)
//        val rval = if(right < arr.size) arr.calc(left, right + 1) else -1
//
//        retval = max(retval, if(lval < rval) {
//            right++
//            rval
//        }
//        else {
//            left++
//            lval
//        })
//    }
//
//    return retval
//}
//
////fun Array<Int>.calc(start : Int, end : Int) = this.sliceArray(IntRange(start, end - 1)).sum() * this.sliceArray(IntRange(start, end - 1)).min()!!
//fun Array<Int>.calc(start : Int, end : Int) : Long {
//    val temp = this.sliceArray(IntRange(start, end - 1))
//    var ret = 0L; var min = Int.MAX_VALUE
//    for(i in temp) {
//        min = kotlin.math.min(i, min)
//        ret += i
//    }
//    return ret * min
//}
