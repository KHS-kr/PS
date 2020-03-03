import java.util.*

//두 점에서만날경우 : 2
//외접, 내접 : 1
//포함 or 만나지않을경우 : 0
//일치 : -1

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()

    for(i in 0 until N) {
        var one = Turret(sc.nextLong(), sc.nextLong(), sc.nextLong())
        var two = Turret(sc.nextLong(), sc.nextLong(), sc.nextLong())

        println(findEnemy(one, two))
    }
}

data class Turret(val x : Long, val y : Long, val r : Long)

fun findEnemy(p1 : Turret, p2 : Turret) : Int {
    val dx = p2.x - p1.x
    val dy = p2.y - p1.y
    val d = dx * dx + dy * dy
    val big = (p1.r + p2.r) * (p1.r + p2.r) //외접
    val small = (p1.r - p2.r) * (p1.r - p2.r) //내접
    
    return if(d > big) 0
    else if(d == big || (d == small && d != 0L)) 1
    else if(d in small + 1 until big) 2
    else if(d == 0L && p1.r == p2.r) -1
    else 0
}
