class Solution {
    fun solution(num: Int): Int {
        var answer = -1

        var mix = num.toLong()

        for(i in 1..501) {
            if(mix == 1L) {
                answer = i - 1
                break;
            }
            if(mix % 2 == 0L)
                mix /= 2
            else
                mix = mix * 3 + 1
        }
        return answer
    }
}
