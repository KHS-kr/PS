class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var arr = arrayOf<Clothes>()
        out@for(t in clothes) {
            for(bigyo in arr) {
                if(bigyo.kind == t[1]) {
                    bigyo.count++
                    continue@out
                }
            }
            arr += Clothes(t[1])
        }

        for(i in 0 until arr.size) {
            answer *= (arr[i].count + 1)
        }
        return answer - 1
    }
}

data class Clothes(var kind : String, var count : Int = 1)
