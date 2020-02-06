class Solution {
    fun solution(heights: IntArray): IntArray {
        val answer = IntArray(heights.size) { 0 }

        for(i in 1 until heights.size) {
            for(j in (0 until i).reversed()) {
                if(heights[j] > heights[i]) {
                    answer[i] = j + 1
                    break
                }
            }
        }
        return answer
    }
}
