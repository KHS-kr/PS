import kotlin.math.sqrt

class Solution {
    fun solution(n: Long) : Long {
        var d = sqrt(n.toDouble())
        var i = d.toInt()

        return if(d == i.toDouble()) (i + 1) * (i + 1).toLong() else -1
    }
}
