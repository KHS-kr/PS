import java.util.*

lateinit var tree : Array<graph>
fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()
    tree = Array(N) { graph('.', '.', '.')}
    for(i in 0 until N) {
        val temp = sc.nextLine().split(" ")
        tree[i].me = temp[0][0]
        tree[i].left = temp[1][0]
        tree[i].right = temp[2][0]
    }

    preOrder('A'); println()
    inOrder('A'); println()
    postOrder('A'); println()

}

fun preOrder(c : Char) {
    if(c == '.') return
    var temp = graph(c, '.', '.')
    for(t in tree)
        if(t.me == c)
            temp = t
    print(temp.me)
    preOrder(temp.left)
    preOrder(temp.right)
}

fun inOrder(c : Char) {
    if(c == '.') return
    var temp = graph(c, '.', '.')
    for(t in tree)
        if(t.me == c)
            temp = t
    inOrder(temp.left)
    print(temp.me)
    inOrder(temp.right)
}

fun postOrder(c : Char) {
    if(c == '.') return
    var temp = graph(c, '.', '.')
    for(t in tree)
        if(t.me == c)
            temp = t
    postOrder(temp.left)
    postOrder(temp.right)
    print(temp.me)
}

data class graph(var me : Char, var left : Char, var right : Char)
