import java.util.*

fun main(array : Array<String>) {
    val sc = Scanner(System.`in`)

    var A = sc.nextInt()
    var B = sc.nextInt()

    val ret = if(A > B) ">" else if(A < B) "<" else "=="
    
    print(ret)
}
