class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = when(MonthToDay(a, b) % 7) {
            1 -> "FRI"
            2 -> "SAT"
            3 -> "SUN"
            4 -> "MON"
            5 -> "TUE"
            6 -> "WED"
            0 -> "THU"
            else -> ""
        }

        return answer
    }

    fun MonthToDay(a : Int, b : Int) : Int {
        val thirtyone = setOf(1, 3, 5, 7, 8, 10, 12)
        var thirty = setOf(4, 6, 9, 11)
        var retval = 0
        for(i in 1 until a) {
            retval += when {
                thirtyone.contains(i) -> 31
                thirty.contains(i) -> 30
                else -> 29 // 윤년
            }
        }

        return retval + b
    }
}
