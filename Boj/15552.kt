import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args : Array<String>) {
    var bfr = BufferedReader(InputStreamReader(System.`in`))
    var n = bfr.readLine().toInt()
    var bfw = BufferedWriter(OutputStreamWriter(System.`out`))

    for(i in 1..n) {
        var s = bfr.readLine()
        var token = StringTokenizer(s, " ")
        val A = token.nextToken().toInt()
        var B = token.nextToken().toInt()

        bfw.write( "${A+B}\n")
    }

    bfr.close();
    bfw.flush();
    bfw.close();

}
