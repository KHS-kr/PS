class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array(arr1.size) { IntArray(arr2[0].size) { 0 }} //초기화

        for(a in 0 until arr1.size) {
            for(b in 0 until arr2[0].size) {
                for(c in 0 until arr1[0].size) {
                    answer[a][b] += arr1[a][c] * arr2[c][b]
                }
            }
        }

        return answer
    }
}
