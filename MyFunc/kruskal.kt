import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = 7; val m = 11

    val arr = mutableListOf<Edge>()
    arr.add(Edge(1, 7, 12))
    arr.add(Edge(1, 4, 28))
    arr.add(Edge(1, 2, 67))
    arr.add(Edge(1, 5, 17))
    arr.add(Edge(2, 4, 24))
    arr.add(Edge(3, 5, 20))
    arr.add(Edge(3, 6, 37))
    arr.add(Edge(4, 7, 13))
    arr.add(Edge(5, 6, 45))
    arr.add(Edge(5, 7, 73))

    arr.sortBy { it.dist }

    val set = IntArray(n) { it }

    var sum = 0

    for(e in arr) {
        if(find(set, e.a - 1, e.b - 1) == 0) {
            sum += e.dist
            unionParent(set, e.a - 1, e.b - 1)
        }
    }

    println(sum)
}

data class Edge(val a : Int, val b : Int, val dist : Int)

fun getParent(arr : IntArray, x : Int) : Int {
    if(arr[x] == x)
        return x
    arr[x] = getParent(arr, arr[x])
    return arr[x]
}

fun unionParent(arr : IntArray, aa : Int, bb : Int) {
    val a = getParent(arr, aa)
    val b = getParent(arr, bb)

    if(a < b) arr[b] = a
    else arr[a] = b
}

fun find(arr : IntArray, aa : Int, bb : Int) : Int {
    val a = getParent(arr, aa)
    val b = getParent(arr, bb)

    return if(a == b) 1 else 0
}
