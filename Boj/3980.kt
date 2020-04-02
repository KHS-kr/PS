import java.util.*
import kotlin.math.max

val arr = Array(11) { IntArray(11) }
val visited = BooleanArray(11)
var max = 0

fun main() = with(Scanner(System.`in`)) {
    repeat(nextInt()) {
        max = 0
        for(i in 0 until 11)
            for(j in 0 until 11)
                arr[i][j] = nextInt()

        soccerTeam(0, 0)
        println(max)
    }
}

fun soccerTeam(n : Int, score : Int) {
    if(n == 11) {
        max = max(max, score)
        return
    }

    for(i in 0 until 11) {
        val temp = arr[i][n]
        if(temp != 0 && !visited[i]) {
            visited[i] = true
            soccerTeam(n + 1, score + temp)
            visited[i] = false
        }
    }
}
