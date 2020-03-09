import java.util.*

val arr = Array(33333) { 0 }
val slide = Array(3333) { 0 }
var diff = 0 //종류
var eat = 0 //먹은

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val d = sc.nextInt()
    val k = sc.nextInt()
    val c = sc.nextInt()
    val cnt = -1
    var ret = 0

    for(i in 0 until N)
        arr[i] = sc.nextInt()

    slide[c] = 1
    diff++

    for(i in 0 until k) {
        if(slide[arr[i]] == 0) diff++
        slide[arr[i]]++
        eat++

        arr[N + i] = arr[i]
    }
    for(i in k until k + N) {
        if(ret < diff)
            ret = diff

        if (slide[arr[i]] == 0)
            diff++
        slide[arr[i]]++
        eat++
        if (slide[arr[i - k]] == 1)
            diff--
        slide[arr[i - k]]--
        eat++
    }

    println(ret)
}

//참고 : https://colorscripter.com/s/HdczG4s
