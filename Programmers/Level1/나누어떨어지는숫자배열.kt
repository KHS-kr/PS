class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var ret = mutableListOf<Int>()

        for(i in arr) {
            if(i % divisor == 0)
                ret.add(i)
        }
        if(ret.size != 0)
            return ret.sorted().toIntArray()
        else
            return intArrayOf(-1)
    }
}
