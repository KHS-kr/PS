import java.util.*
import kotlin.math.min

lateinit var arr : Array<Friend>
lateinit var kb : Array<Array<Int>>
lateinit var findMin : Array<Int>
var retval = 0
fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val M = sc.nextInt()
    arr = Array(M) { Friend(sc.nextInt() - 1, sc.nextInt() - 1) }
    kb = Array(N) { Array(N) { 0 } }
    findMin = Array(N) { 0 }

    for(f in arr) {
        kb[f.a][f.b] = 1
        kb[f.b][f.a] = 1
    }
    dfs()
    for(i in findMin.indices) {
        for(j in findMin.indices) {
            findMin[i] += kb[i][j]
        }
    }
    for(i in findMin.indices)
        if(findMin[retval] > findMin[i])
            retval = i

    println(retval + 1)
}

data class Friend(val a : Int, val b : Int)

//j -> i -> k
fun dfs() {
    for(i in findMin.indices) {
        for(j in findMin.indices) {
            for(k in findMin.indices) {
                if(j == k)
                    continue
                else if(kb[j][i] != 0 && kb[i][k] != 0) {
                    kb[j][k] = if(kb[j][k] == 0) kb[j][i] + kb[i][k]
                        else min(kb[j][k], kb[j][i] + kb[i][k])
                }
            }
        }
    }

}
