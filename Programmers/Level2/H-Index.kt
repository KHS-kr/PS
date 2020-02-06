class Solution {
    fun solution(citations: IntArray): Int {
        for(c in (1..citations.size).reversed()) {
            var hcount = 0
            for(i in citations) {
                if(i >= c)
                    hcount++
            }
            if(c <= hcount)
                return c
        }
        return 0
    }
}
