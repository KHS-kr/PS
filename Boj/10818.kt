import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()

    var A = sc.nextInt()
    var Max = A
    var Min = A

    for(i in 0 until (N - 1)) {
        A = sc.nextInt()
        if(Max < A)
            Max = A
        else if(Min > A)
            Min = A
    }

    println("${Min} ${Max}")

}
