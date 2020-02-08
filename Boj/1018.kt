import java.lang.Exception
import java.util.*

var firstblack = Array(8) {i : Int -> Array(8) {j : Int ->
    if((i + j) % 2 == 0) 'B'
    else 'W'
}}

var firstwhite = Array(8) {i : Int -> Array(8) {j : Int ->
    if((i + j) % 2 == 0) 'W'
    else 'B'
}}

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()
    var M = sc.nextInt()
    sc.nextLine()

    var arr = Array(N) {Array(M) {'B'}}

    for(i in 0 until N) {
        var input = sc.nextLine()
        for(j in 0 until M) {
            arr[i][j] = input[j]
        }
    }

    var result = N * M
    for(i in 0..N - 8) {
        for(j in 0..M - 8) {
            result = Math.min(Math.min(result, fb_bigyo(arr, i, j)), fw_bigyo(arr, i, j))
        }
    }

    println(result)
}

fun fb_bigyo(arr : Array<Array<Char>>, x : Int, y : Int) : Int {
    var count = 0

    for(i in x until (x + 8)) {
        for(j in y until (y + 8)) {
            if (firstblack[i - x][j - y] != arr[i][j])
                count++
        }
    }

    return count
}

fun fw_bigyo(arr : Array<Array<Char>>, x : Int, y : Int) : Int {
    var count = 0

    for(i in x until (x + 8)) {
        for(j in y until (y + 8)) {
            if(firstwhite[i - x][j - y] != arr[i][j])
                count++
        }
    }

    return count
}
