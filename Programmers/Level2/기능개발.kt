class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val ps = List(progresses.size) { i -> psps(progresses[i], speeds[i], false) }
        while(!ps.allTrue()) {
            ps.oneDay()
            var temp = ps.afterDay()
            if(temp != 0)
                answer += temp
        }
        return answer
    }
}

data class psps (var progress : Int, var speed : Int, var baepo : Boolean)

fun List<psps>.allTrue() : Boolean {
    for(i in 0 until this.size)
        if(!this[i].baepo)
            return false
    return true
}

fun List<psps>.oneDay() {
    for(obj in this) {
        if(!obj.baepo)
            obj.progress += obj.speed
    }
}

fun List<psps>.afterDay() : Int {
    var sum = 0
    for(i in 0 until this.size) {
        if(!this[i].baepo && this[i].progress >= 100) {
            var temp = true
            for(j in 0 until i) {
                if(!this[j].baepo)
                    temp = false
            }
            if(temp) {
                this[i].baepo = true
                sum += 1
            }
        }
    }

    return sum
}
