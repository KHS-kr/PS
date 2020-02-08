import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    
    for(i in 0 until n) {
        for(j in 0 until n)
            print("*")
        println()
    }
    br.close()
}
