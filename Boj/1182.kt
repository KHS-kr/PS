import java.util.*

var N = 0
var S = 0
var retval = 0
lateinit var arr : Array<Int>

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    S = sc.nextInt()
    arr = Array(N) { 0 }

    for(i in 0 until N)
        arr[i] = sc.nextInt()

    subNumber(0, 0)
    if(S == 0)
        retval--
    println(retval)
}

/*
부분 수열의 갯수는 생각하지않고 현재 인덱스를 더하거나 안더하거나 그 경우를
재귀함수를 통해서 모두 구해서 배열 사이즈랑 인덱스가 똑같아질경우 => 끝까지 탐색한 경우
S값고 합이 똑같다면 결과값 +1 한다.
 */
fun subNumber(index : Int, sum : Int) {
    if(index == N) {
        if(sum == S)
            retval++
        return
    }

    subNumber(index + 1, sum + arr[index])
    subNumber(index + 1, sum)
}
