class Solution {
    fun solution(n: Long): IntArray {
        var temp = mutableListOf<Int>()
        for(c in n.toString().toCharArray().reversed()) {
            temp.add(c.toString().toInt())
        }
        return temp.toIntArray()
    }
}
