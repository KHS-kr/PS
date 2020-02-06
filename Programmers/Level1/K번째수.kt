class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()

        for(command in commands)
            answer += cutting(array, command)
        return answer
    }

    fun cutting(array : IntArray, command : IntArray) =
        array.slice(IntRange(command[0] - 1, command[1] - 1)).sorted()[command[2] - 1]
}
