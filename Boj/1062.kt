import java.util.*
import kotlin.math.max

var N = 0; var K = 0
lateinit var arr : Array<String>
val usable = BooleanArray(26)
var ret = 0

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    K = nextInt()
    nextLine()
    arr = Array(N) { nextLine() }

    if(K == 26) {
        println(N)
        return
    }
    else if(K < 5) {
        println(0)
        return
    }
    K -= 5
    for(i in arr.indices)
        arr[i] = arr[i].substring(IntRange(4, arr[i].length - 5))

    usable['a' - 'a'] = true; usable['n' - 'a'] = true; usable['t' - 'a'] = true
    usable['i' - 'a'] = true; usable['c' - 'a'] = true

    DoUKnowEnglish(0, 0)
    println(ret)
}

fun DoUKnowEnglish(alphabet : Int, count : Int) {
    if(count == K) {
        var temp = 0
        var flag : Boolean
        for(str in arr) {
            flag = true
            for(c in str)
                if(!usable[c - 'a']) {
                    flag = false
                    break
                }

            if(flag)
                temp++
        }
        ret = max(ret, temp)
        return
    }

    for(i in alphabet until 26)
        if(!usable[i]) {
            usable[i] = true
            DoUKnowEnglish(i, count + 1)
            usable[i] = false
        }
}

/*
anta rc tica
anta hello tica
anta car tica
 */
