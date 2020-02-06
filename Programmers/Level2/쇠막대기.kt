class Solution {
    fun solution(arrangement: String): Int {
        val arr = arrangement
        var list = ArrayList<Char>()
        var answer = 0
        var count = 0
        var cur = 0

        while(cur != arr.length) {
            if(arr[cur] == '(') {
                if(arr[cur + 1] == ')')
                    answer += count
                else
                    count++
            }
            else {
                if(arr[cur - 1] != '(') {
                    answer++
                    count--
                }
            }
            cur++
        }
        return answer
    }

}
