class Solution {
    fun solution(s: String): String {
        val a = s.split(" ").map { str -> str.toInt() }.sorted()
        return "${a[0]} ${a[a.size - 1]}"
    }
}
