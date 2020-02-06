class Solution {
    fun solution(s: String): String {
        var answerbuilder = StringBuilder()
        var space = true
        for(c in s) {
            if(space && c != ' ') {
                space = false
                answerbuilder.append(c.toUpperCase())
            }
            else {
                if(c == ' ')
                    space = true
                answerbuilder.append(c.toLowerCase())
            }
        }
        return answerbuilder.toString()
    }
}
