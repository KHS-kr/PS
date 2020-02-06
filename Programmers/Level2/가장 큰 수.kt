object myComparator : Comparator<String> {
    override fun compare(o1: String, o2: String) = (o1 + o2).compareTo(o2 + o1)
}

class Solution {
    fun solution(numbers: IntArray): String {
        var answerbulder = StringBuilder()
        val arr = Array(numbers.size) { i -> numbers[i].toString()}

        arr.sortWith(myComparator)

        if (arr.reversed()[0].startsWith("0"))
            return "0"

        for (str in arr.reversed())
            answerbulder.append(str)
        return answerbulder.toString()
    }
}
