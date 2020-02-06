import kotlin.math.sqrt

class Solution {
    fun solution(nums: IntArray): Int {
        var sosu = intArrayOf()

//        for(a in nums) {
//            second@for(b in nums) {
//                if(a == b)
//                    continue@second
//                third@for(c in nums) {
//                    if(a == c || b == c)
//                        continue@third
//                    val temp = a + b + c
//                    if(findSosu(temp) && !sosu.contains(temp)) {
//                        sosu += temp
//                    }
//                }
//            }
//        }
        for(a in 0 until nums.size - 2) {
            for(b in a + 1 until nums.size - 1) {
                for(c in b + 1 until nums.size) {
                    val temp = nums[a] + nums[b] + nums[c]
                    if(findSosu(temp))
                        sosu += temp
                }
            }
        }
        return sosu.size
    }

    fun findSosu(n : Int) : Boolean {
        for(i in 2..sqrt(n.toDouble()).toInt())
            if(n % i == 0)
                return false
        return true
    }
}
