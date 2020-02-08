import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val str = sc.nextLine()

    println(croatia(str))
}

fun croatia(str : String) : Int {
    var count = 0
    var i = 0
    var list = listOf('c', 'd', 'l', 'n', 's', 'z')
    while(i < str.length) {
        var c = str[i]
        if(c in list && i != str.length - 1) {
            when(c) {
                'c' -> if(str[i + 1] == '=' || str[i + 1] == '-') i++
                'd' -> if(str[i + 1] == '-') i++
                else if(str[i + 1] == 'z' && i + 1 != str.length - 1)
                    if(str[i + 2] == '=') i += 2
                'l', 'n' -> if(str[i + 1] == 'j') i++
                's', 'z' -> if(str[i + 1] == '=') i++
            }
        }

        i++
        count++
    }

    return count
}
