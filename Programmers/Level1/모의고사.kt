class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        val one = intArrayOf(1, 2, 3, 4, 5)
        val two = intArrayOf(1, 3, 4, 5)
        val thr = intArrayOf(3, 1, 2, 4, 5)
        val score = intArrayOf(0, 0, 0)

        for((index, answer) in answers.withIndex()) {  
            if(answer == one[index % 5])
                score[0]++
            if(index % 2 == 0) {
                if (answer == 2)
                    score[1]++
            }
            else if(answer == two[(index % 8) / 2])
                score[1]++

            if(answer == thr[(index % 10) / 2])
                score[2]++
        }

        val max = score.max()!!
        for(i in score.indices)
            if(max == score[i])
                answer += (i + 1)
        return answer
    }
}
