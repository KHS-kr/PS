import java.util.*
import kotlin.system.exitProcess

val sdoku = Array(9) { IntArray( 9 ) }
var zero = 0
//i번째 줄에 해당하는 숫자
val xvisited = Array(9) { BooleanArray(9) { false } }
//i번째 열에 해당하는 숫자
val yvisited = Array(9) { BooleanArray(9) { false } }
//i번쨰 3*3에 해당하는 숫
val svisited = Array(9) { BooleanArray(9) { false } }

fun main() = with(Scanner(System .`in`)) {
    for(i in 0 until 9) {
        val temp = nextLine()
        for (j in 0 until 9) {
            sdoku[i][j] = temp[j].toString().toInt()
        }
    }
    for(i in 0 until 9)
        for(j in 0 until 9) {
            if(sdoku[i][j] != 0) {
                xvisited[i][sdoku[i][j] - 1] = true
                yvisited[j][sdoku[i][j] - 1] = true
                svisited[(i / 3) * 3 + (j / 3)][sdoku[i][j] - 1] = true
            }
        }

    dfs(0)
}

fun dfs(n : Int) {
    val x = n / 9
    val y = n % 9

    if(n == 81) {
        for(a in sdoku) {
            for(i in a)
                print("$i")
            println()
        }
        exitProcess(0)
    }

    if(sdoku[x][y] == 0) {
        for(i in 0 until 9) {
            if(!xvisited[x][i] && !yvisited[y][i] && !svisited[(x / 3) * 3 + (y / 3)][i]) {
                xvisited[x][i] = true
                yvisited[y][i] = true
                svisited[(x / 3) * 3 + (y / 3)][i] = true
                sdoku[x][y] = i + 1
                dfs(n + 1)
                sdoku[x][y] = 0
                xvisited[x][i] = false
                yvisited[y][i] = false
                svisited[(x / 3) * 3 + (y / 3)][i] = false
            }
        }
    }
    else
        dfs(n + 1)
}
