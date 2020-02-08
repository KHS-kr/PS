import java.util.*

fun main(args : Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()

    var c : Int = 0

    for(i in 1..n)
        if(i.hansu())
            c++

    print(c)
}

fun Int.hansu() : Boolean{
    var chai : Int = 0
    val l = this.toString().length
    if(l == 1 || l == 2)
        return true
    else {
        chai = this.toString()[0].toInt() - this.toString()[1].toInt()
        for(i in 1 until l - 1) {
            if(chai != this.toString()[i].toInt() - this.toString()[i + 1].toInt())
                return false
        }
        return true
    }
}
