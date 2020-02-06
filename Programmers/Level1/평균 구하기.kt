class Solution {
    fun solution(arr: IntArray): Double {
        var answer = 0.0
        var sum = 0
        for(i in arr)
            sum += i
        
        answer = sum / arr.size.toDouble()
        return answer
    }
}
