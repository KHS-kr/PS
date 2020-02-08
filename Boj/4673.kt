var arr : Array<Boolean> = Array(10001, {true})

fun main(args : Array<String>) {
    for(i in 1..10000)
        selfNum(i)

    for(i in 1..10000)
        if(arr[i])
            println(i)
}

fun selfNum(n : Int) {
    (n + n.jarisuhab()).run {
        if(this <= 10000 && arr[this]) {
            arr[this] = false
            selfNum(this)
        }
    }

}

//fun Int.jarisuhab() = this / 1000 + this / 100 + this / 10 + this % 10
fun Int.jarisuhab() : Int {
    var ret : Int = 0
    ret += this % 10
    ret += this / 10 % 10
    ret += this / 100 % 10
    ret += this / 1000 % 10

    return ret
}
