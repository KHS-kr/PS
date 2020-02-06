class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var n = arr1.size
        var m = arr1[0].size
        var arr = Array(n) { IntArray(m) { 0 }}
        for(i in 0 until n) {
            for(j in 0 until m) {
                arr[i][j] = arr1[i][j] + arr2[i][j]
            }
        }
        return arr
    }
}
