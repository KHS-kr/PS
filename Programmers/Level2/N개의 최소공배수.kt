class Solution {
    fun solution(arr: IntArray): Int {
        var lcd = arr.sorted()[arr.size - 1] - 1

        out@while(true) {
            lcd++
            for(i in arr) {
                if(lcd % i != 0)
                    continue@out
            }
            return lcd
        }
    }
}
