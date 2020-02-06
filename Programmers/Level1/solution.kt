import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer : Long = 0
        var start = if(a > b) b else a
        var end = if(a > b) a else b
        for(i in start..end)
            answer += i
        return answer
    }
}
