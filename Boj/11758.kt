import java.util.*

fun main() = with(Scanner(System .`in`)) {
    val arr = Array(3) { Pair(nextInt(), nextInt()) }

    println(ccw(arr[0], arr[1], arr[2]))
}

fun ccw(a : Pair<Int, Int>, b : Pair<Int, Int>, c : Pair<Int, Int>) : Int {
    var temp = a.first * b.second + b.first * c.second + c.first * a.second;
    temp -= (a.second * b.first + b.second * c.first + c.second * a.first)

    return if(temp > 0) 1
    else if(temp < 0) -1
    else 0
}
