import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()
    sc.nextLine()

    var ret = 0
    for(i in 0 until N) {
        val str = sc.nextLine()
        if(group(str))
            ret++
    }

    println(ret)
}

fun group(str : String) : Boolean {
    var arr = Array(26) {false}

    for(i in 0 until str.length) {
        var c = str[i]
        var temp = c.toInt() - 'a'.toInt()

        if(!arr[temp])
            arr[temp] = true
        else {
            if(str[i - 1] != c)
                return false
        }
    }

    return true
}
