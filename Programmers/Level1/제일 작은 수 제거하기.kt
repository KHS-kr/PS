class Solution {
    fun solution(arr: IntArray) = if(arr.size == 1) intArrayOf(-1) else arr.filter { i -> i != arr.min()}.toIntArray()
}
