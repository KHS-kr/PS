class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var max = if(a > b) a else b
        var min = if(a > b) b else a
        for(i in 1..n.twosqrt()) {
            if(max - min == 1 && max % 2 == 0)
                return i
            max = (max + 1) / 2
            min = (min + 1) / 2
        }
        return 0
    }

    fun Int.twosqrt() : Int {
        var temp = this
        var count = 0
        while(temp != 1) {
            temp /= 2
            count++
        }
        return count
    }
}
