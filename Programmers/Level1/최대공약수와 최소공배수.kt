class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var a = if(n > m) n else m
        var b = if(n > m) m else n

        var gcd : Int; var lcm : Int

        while(b != 0) {
            var temp = a % b
            a = b
            b = temp
        }
        gcd = a
        lcm = n * m / gcd

        var answer = intArrayOf(gcd, lcm)
        return answer
    }
}
