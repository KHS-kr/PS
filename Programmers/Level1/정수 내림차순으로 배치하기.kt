class Solution {
    fun solution(n: Long): Long {
        var ret = ""
        for(i in n.toString().toCharArray().sorted())
            ret = i + ret
        return ret.toLong()
    }
}
