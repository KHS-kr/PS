class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = -1
        var locarr = MutableList(priorities.size) { i -> i }
        var pri = priorities.toMutableList()

        for(i in 0 until pri.size) {
            while (true) {
                if (pri.isSorted(i))
                    break
                pri.add(pri.removeAt(i))
                locarr.add(locarr.removeAt(i))
            }
            if(location == locarr[i])
                answer = i + 1
        }

        return answer
    }

    fun MutableList<Int>.isSorted(x : Int) : Boolean {
        val prev = this[x]
        for(i in x + 1 until this.size) {
            if(prev < this[i])
                return false
        }
        return true
    }
}
