class Solution {
    fun solution(s: String): String {
        var small = ""
        var big = ""
        for(c in s) {
            if(c.isLowerCase())
                small += c
            else
                big += c
        }
        var answer = ""
        for(c in small.toCharArray().sorted().reversed()) 
            answer += c
        for(c in big.toCharArray().sorted().reversed())
            answer += c
        return answer
    }
}
