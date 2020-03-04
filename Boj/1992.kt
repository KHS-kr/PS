import java.util.*
import kotlin.math.pow

lateinit var arr : Array<Array<Int>>

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()
    arr = Array(N) { Array(N) { 0 } }

    for(i in 0 until N) {
        val temp = sc.nextLine()
        for (j in 0 until N)
            arr[i][j] = temp[j].toString().toInt()
    }

    var temp = arr[0][0]
    for(i in 0 until N)
        for(j in 0 until N)
            if(arr[i][j] != temp) {
                temp = 2
                break
            }
    
    quadTree(N, 0, 0)
}

fun quadTree(n : Int, x : Int, y : Int) {
    var check = check(n, x, y)
    if(check == 0 || check == 1)
        print(check)
    else {
        print("(")
        quadTree(n / 2, x, y)
        quadTree(n / 2, x, y + n / 2)
        quadTree(n / 2, x + n / 2, y)
        quadTree(n / 2, x + n / 2, y + n / 2)
        print(")")
    }
}

fun check(n : Int, x : Int, y : Int) : Int {
    var retval = arr[x][y]
    for(i in x until x + n)
        for(j in y until y + n)
            if(retval != arr[i][j])
                return 2
    return retval
}
