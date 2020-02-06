class Solution {
    fun solution(brown: Int, red: Int): IntArray {
        var answer = intArrayOf()

        for(x in 3..2501) {
            for(y in 3..x) {
                if(2 * (x + y - 2) == brown)
                    if(x * y - brown == red) {
                        answer += x
                        answer += y
                        break
                    }
            }
        }
        return answer
    }
}
