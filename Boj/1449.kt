import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    val L = sc.nextInt()
    val Real = L - 1
    var arr = mutableListOf<Int>()

    for(i in 0 until N)
        arr.add(sc.nextInt())
    arr.sort()

    var retval = 0

    while(arr.size != 0) {
        val temp = arr[0]
        retval++
        arr.remove(temp)
        var remove = arrayOf<Int>()
        for(i in arr.indices)
            if(arr[i] >= temp && arr[i] <= temp + Real)
                remove += i

        for(i in remove.indices)
            arr.remove(arr[0])
    }

    println(retval)
}
