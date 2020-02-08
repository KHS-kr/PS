import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var N = sc.nextInt()

    var arr = ArrayList<dungchi>()

    for(i in 0 until N) {
        var w = sc.nextInt()
        var h = sc.nextInt()

        sc.nextLine()

        arr.add(dungchi(w, h))
    }

    bigyo(arr)

    for(dc in arr) {
        print("${dc.score} ")
    }
}

data class dungchi(var weight : Int, var height : Int, var score : Int = 1)

fun bigyo(arr : ArrayList<dungchi>) {
    for(i in 0 until arr.size) {
        for(j in 0 until arr.size) {
            if(arr[i].height > arr[j].height && arr[i].weight > arr[j].weight)
                arr[j].score += 1
        }
    }
}
