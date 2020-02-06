class Solution {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(target, numbers, 0)
        return answer
    }

    fun dfs (target : Int, arr : IntArray, depth : Int) {
        if(depth == arr.size) {
            var sum = 0
            for(i in arr)
                sum += i
            if(sum == target)
                answer++
            return
        }
        else {
            dfs(target, arr, depth + 1)

            arr[depth] *= -1
            dfs(target, arr, depth + 1)
        }
    }
}
