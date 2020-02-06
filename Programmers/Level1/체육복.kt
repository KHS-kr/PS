class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var same = 0 //잃어버렸는데 여분가져온사람
        var thank = 0 //빌려받은사람

        for(i in lost.indices) {
            for(j in reserve.indices) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1
                    reserve[j] = -1
                    same++
                    break
                }
            }
        }

        for(i in lost.indices) {
            for(j in reserve.indices) {
                if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    thank++
                    reserve[j] = -1
                    break
                }
            }
        }

        return n - lost.size + same + thank
    }
}
