import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var A = sc.nextInt()

    if(A % 4 == 0) {
        if(A % 100 == 0) {
            if(A % 400 == 0)
                println(1)
            else
                println(0)
        }
        else {
            println(1)
        }
    }
    else
        println(0)
}
