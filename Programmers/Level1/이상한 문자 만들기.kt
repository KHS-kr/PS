class Solution {
    fun solution(s: String): String {
        var answer = ""
        var temp = s.split(" ")
        for(str in temp) {
            for(i in 0 until str.length) {
                answer += if(i % 2 == 0) str[i].toUpperCase()
                else str[i].toLowerCase()
            }
            answer += ' '
        }
        
        return answer.removeRange(answer.length - 1, answer.length)
    }
}
