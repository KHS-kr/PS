class Solution {
    fun solution(baseball: Array<IntArray>): Int {
        var answer = 0
        var arr = Array(baseball.size) { i -> NumberBB(baseball[i][0] / 100, baseball[i][0] / 10 % 10, baseball[i][0] % 10,
            baseball[i][1], baseball[i][2]) }.sortedBy { it.strike }

        out@for(i in 123..987) {
            val a = i / 100
            val b = i / 10 % 10
            val c = i % 10
            if(a == b || a == c || b == c)
                continue
            else if(b == 0 || c == 0)
                continue
            else {
                for(bb in arr) {
                    var strike = 0
                    var ball = 0
                    if(bb.one == a) strike++
                    if(bb.two == b) strike++
                    if(bb.three == c) strike++
                    
                    if(bb.one == b || bb.one == c) ball++
                    if(bb.two == a || bb.two == c) ball++
                    if(bb.three == a || bb.three == b) ball++
                    
                    // ball = strike - ball
                    if(bb.strike != strike || bb.ball != ball)
                        continue@out
                }
                answer++
            }
        }
        return answer
    }
}

data class NumberBB(var one : Int, var two : Int, var three : Int,
                    var strike : Int, var ball : Int)
