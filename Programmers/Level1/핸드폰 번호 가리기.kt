class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        for(c in phone_number.mapIndexed { index, c -> if(index >= phone_number.length - 4) c else '*' })
            answer += c
        return answer
    }
}
