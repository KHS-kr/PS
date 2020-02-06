class Solution {
    fun solution(x: Int): Boolean {
        var harsard = 0
        for(c in x.toString())
            harsard += c.toString().toInt()
        return if(x % harsard == 0) true else false
    }
}
