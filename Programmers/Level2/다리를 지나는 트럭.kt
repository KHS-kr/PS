class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val psps = MutableList(truck_weights.size) { i -> ps(truck_weights[i], 0) }
        var inBridge = mutableListOf<Int>()
        var cur = 0
        while(!psps.isEnd(bridge_length)) {
            if(psps.sumWeight(bridge_length) <= weight && cur < truck_weights.size) {
                if(psps.sumWeight(bridge_length) + psps[cur].weight <= weight) {
                    cur++
                }
            }

            for(i in 0 until cur)
                if(psps[i].length != bridge_length)
                    psps[i].length++
            answer++
        }
        return answer + 1
    }
}

data class ps (var weight: Int, var length : Int)

fun MutableList<ps>.sumWeight(length : Int) : Int{
    var sum = 0
    for(i in this) {
        if(i.length != length && i.length != 0)
            sum += i.weight
    }
    return sum
}

fun MutableList<ps>.isEnd(length : Int) : Boolean {
    for(i in this)
        if(i.length != length)
            return false
    return true
}
