import java.util.*
import kotlin.math.abs
import kotlin.math.max

lateinit var input : Array<Array<Int>>
var N = 0; var M = 0; var D = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    D = sc.nextInt()

    input = Array(N + 1) { Array(M) { 2 } } // 0 : nobody, 1 : enemy, 2 : Archor
    for(i in 0 until N)
        for(j in 0 until M)
            input[i][j] = sc.nextInt()

    println(war())
}

fun war() : Int{ //경우의수 계산
    var archor = Array(3) { 0 }
    var ret = 0
    for(i in 0 until M - 2) { //i, j, k 궁수의 위치 전수조사
        for(j in i + 1 until M - 1) {
            for(k in j + 1 until M) {
                val temparr = Array(N + 1) { i -> Array(M) { j -> input[i][j] } }
                var count = 0
                archor[0] = i
                archor[1] = j
                archor[2] = k

                for(x in 0 until N) { //턴마다(한줄씩 내려올때마다) 죽일수잇는 인원 카운트, kill 함수 밑에서 한줄씩 내려온다.
                    count += kill(temparr, archor)
                }

                ret = max(ret, count) //기존의 결과값이랑 최댓값을 비교해서 결과값으로 넣는다
            }
        }
    }

    return ret
}

fun kill(arr : Array<Array<Int>>, archor : Array<Int>) : Int { //턴마다 몇명 죽일 수 있는지 반환하는 함수
    val enemy = Array(3) { mutableListOf<Point>() } //3명의 궁수가 죽이는 인원
    for(x in 0 until 3) { // 궁수
        for(i in 0 until N) { //i, j 좌표
            for(j in 0 until M) {
                if(arr[i][j] != 1) //만약 1이 아니면(-1 = 갈 수 없는 곳, 0 = 아무도 없는곳, 1 = 적, 2 = 성) 다른데 탐색색
                   continue
                val dis = abs(N - i) + abs(j - archor[x]) //거리계산
                if(dis <= D) //만약 거리보다 작으면 일단 리스트에 넣어놓는다
                    enemy[x].add(Point(i, j, dis))
            }
        }
        enemy[x].sortBy { it.dis } //거리순으로 정렬
    }
    val enemies = mutableListOf<Point>()

    out@for(x in 0 until 3) {
        if(enemy[x].size == 0)
            continue@out
        val temp = enemy[x][0].dis //최소거리값 넣어놓기
        val min = enemy[x].filter { it.dis == temp }.sortedBy { it.y }[0] //최소거리값이면서 가장 왼쪽에있는(y값이 가장 작은) 좌표 넣어두기
        for(e in enemies) { //같은 좌표가 죽일 대상(궁수 3명 총합)에 있는지 체크
            if(e.x == min.x && e.y == min.y)
                continue@out
        }
        arr[min.x][min.y] = 0 //죽인 좌표 0으로 만들기
        enemies.add(min)
    }

    //죽인갯수 카운트하고나서 한줄씩 내리기
    var temp = Array(N - 1) { i -> Array(M) { j -> arr[i][j] } } //맨마지줄(성 제외)을 제외한 나머지줄 복사
    arr[0] = Array(M) { -1 } //맨위에줄 -1로 치환
    for(i in 1 until N) { //복사한 것을 2번째줄 부터 넣어줌
        for(j in 0 until M) {
            arr[i][j] = temp[i - 1][j]
        }
    }
    return enemies.size //죽인 숫자 리턴
}

data class Point(val x : Int, val y : Int, val dis : Int)
