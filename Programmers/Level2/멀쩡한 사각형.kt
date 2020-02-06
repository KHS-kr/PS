class Solution {
    fun solution(w: Int, h: Int): Long {
                var a = if(w > h) w else h
        var b = if(w > h) h else w
        
        while(b != 0) {
            var temp = a % b
            a = b
            b = temp
        }
        
        val gcd = a
        
        var answer = w.toLong() * h - (w / gcd + h / gcd - 1) * gcd
        return answer
    }
}
