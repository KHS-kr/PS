import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine() + "+"
    var temp = ""
    var ret = 0
    var minus = false


    for(i in str.indices) {
        if (str[i] == '+' || str[i] == '-') {
            if (minus)
                ret -= temp.toInt()
            else
                ret += temp.toInt()
            if (str[i] == '-')
                minus = true
            temp = ""
        }
        else
            temp += str[i]
    }

    println(ret)
}
