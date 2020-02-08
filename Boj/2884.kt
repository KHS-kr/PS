import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var A = sc.nextInt()
    var B = sc.nextInt()

    var h = if(B - 45 < 0) A - 1 else A
    var m = if(B - 45 < 0) B + 15 else B - 45
    
    println("${if(h < 0) h + 24 else h} $m")
}
