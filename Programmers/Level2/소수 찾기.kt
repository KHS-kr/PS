import kotlin.math.sqrt

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        var sosus = IntArray(Math.pow(10.0, numbers.length.toDouble()).toInt()) { i -> i }.filter { i -> i.findSosu()}
        var count = IntArray(10) { 0 }
        for(c in numbers)
            count[c.toString().toInt()]++
        for(i in sosus) {
            var str = i.toString()
            var temp = IntArray(10) { 0 }
            for(c in str)
                temp[c.toString().toInt()]++
            var yn = true
            for(j in 0..9)
                if(count[j] < temp[j]) {
                    yn = false
                    break
                }
            if(yn)
                answer++
        }
        return answer
    }
}

fun Int.findSosu() : Boolean {
    for(i in 2..sqrt(this.toDouble()).toInt())
        if(this % i == 0)
            return false
    if(this < 2)
        return false
    return true
}
