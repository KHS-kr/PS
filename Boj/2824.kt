import java.math.BigInteger
import java.util.*

var N = 0; var M = 0
lateinit var arr : IntArray
lateinit var brr : IntArray

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    arr = IntArray(N) { nextInt() }
    M = nextInt()
    brr = IntArray(M) { nextInt() }

    var A = BigInteger.valueOf(1)
    var B = BigInteger.valueOf(1)

    for(i in arr)
        A = A.multiply(BigInteger.valueOf(i.toLong()))
    for(i in brr)
        B = B.multiply(BigInteger.valueOf(i.toLong()))

    val ret = A.gcd(B).toString()

    println(if(ret.length > 9) ret.substring(IntRange(ret.length - 9, ret.length - 1)) else ret)
}
