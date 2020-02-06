import kotlin.math.min

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        val str = CharArray(name.length) { 'A' }
        var cur = 0

        while(String(str) != name) {
            if(name[cur] == str[cur]) {
                //왼쪽 오른쪽중에 name과 str 다르고 가장 적은 횟수로 이동할 수 있는 곳 찾기
                var left = 1
                var right = 1

                //right 횟수 체크
                while(str[(cur + right) % str.size] == name[(cur + right) % str.size])
                    right++
                //left 횟수 체크
                while(str[if(cur - left < 0) cur - left + str.size else cur - left] == name[if(cur - left < 0) cur - left + str.size else cur - left])
                    left++

                //right left중 작은거 선택
                cur = when {
                    left >= right -> (cur + right) % str.size
                    cur - left < 0 -> cur - left + str.size
                    else -> cur - left
                }

                answer += min(left, right)
            }
            else {
                answer += name[cur].findMinMove()
                str[cur] = name[cur]
            }
        }
        return answer
    }
}

fun Char.findMinMove() = min(this.toInt() - 65, 91 - this.toInt())
