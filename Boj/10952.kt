import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    while(true) {
        var A = sc.nextInt()
        var B = sc.nextInt()
        if(A == 0 && B == 0)
            break
        println(A + B)
    }

}
