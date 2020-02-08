import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var input = scanner.nextLine()
    var arr : Array<Int> = Array(26) {-1}

    for(i in 0 until input.length)
        if(arr[input[i].toInt() - 97] == -1)
            arr[input[i].toInt() - 97] = i

    for(i in arr)
        print("$i ")
}
