class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for(c in s) {
            if(!c.isLetter()) {
                answer += c
                continue
            }
            var upper = c.isUpperCase()
            var temp = c.toLowerCase().toInt()
            temp += if(temp + n > 122)
                n - 26
            else
                n

            answer += if(upper)temp.toChar().toUpperCase() else temp.toChar()
        }
        return answer
    }
}

//65 A 90 Z
//97 a 122 z
