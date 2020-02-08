import java.util.*

fun movie(n : Int) : Int {
    var ret = 666

    for(i in 1 until n) {
        var find = true

        while(find) {
            ret++

            if(ret.toString().contains("666"))
                find = false
        }
    }

    return ret
}
