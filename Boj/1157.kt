import java.util.*

fun main(args : Array<String>) {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine();
    var arr : Array<Int> = Array(26, {0})

    for(c : Char in str.toLowerCase())
        arr[c.toInt() - 97] += 1

    print(arr.max())
}

fun Array<Int>.max() : Char {
    var max = 0

    for(i in 1 until 26) {
        if (this[max] < this[i])
            max = i
    }

    for(i in  0 until 26) {
        if(i == max)
            continue
        if(this[i] == this[max])
            return '?'
    }

    return (max + 65).toChar().toUpperCase()
}
