import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var str = scanner.nextLine()

    var token = StringTokenizer(str, " ")

    var arr : Array<Int> = Array(8, {0})

    var i = 0
    while(token.hasMoreTokens()) {
        arr[i] = token.nextToken().toInt()
        i++
    }

    i = 0
    if(arr[i] != 1 && arr[i] != 8)
        println("mixed")
    else {
        if(arr[i] == 1)
            i = -1
        else
            i = 1
        for(n in 0..6) {
            if(i != (arr[n] - arr[n + 1])) {
                println("mixed")
                return
            }

        }
    }

    if(i == 1)
        println("descending")
    else
        println("ascending")
}
