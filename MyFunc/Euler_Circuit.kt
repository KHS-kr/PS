import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arr = Array(N) { IntArray(N) { nextInt() } }

    val circuit = Euler_Circuit(N, arr)
    circuit.init()
    if(circuit.isValid()) {
        circuit.getEulerCircuit()
    }
    else
        println(-1)
}

data class Euler_Circuit(val N : Int,
                         val graph : Array<IntArray>,
                         val residue_vertex : HashSet<Int> = HashSet()) {
    val order = Stack<Int>()
    val final_order = Stack<Int>()

    fun init() {
        for(i in 0 until N)
            residue_vertex.add(i)
    }

    fun remove(i : Int, j : Int) {
        graph[i][j]--
        graph[j][i]--
    }
    fun degree(n : Int) : Int {
        var degree = 0
        for(i in 0 until N)
            degree += graph[n][i]
        return degree
    }

    fun isValid() : Boolean {
        for(i in 0 until N)
            if(degree(i) % 2 != 0)
                return false
        return true
    }

    fun get_circuit(from : Int) {
        var successor = 0
        for(i in 0 until N) {
            if(graph[from][i] != 0) {
                order.push(i)
                remove(from, i)
                successor = i
                break
            }
        }
        if(degree(successor) != 0)
            get_circuit(successor)
        else
            return
    }

    fun getEulerCircuit() {
        var v = 0
        order.push(v)

        while(!order.isEmpty()) {
            if(degree(order.peek()) != 0) {
                get_circuit(order.peek())
            }
            else {
                residue_vertex.remove(order.peek())
                final_order.push(order.pop())
            }
        }
        while(!final_order.empty()) {
            print(final_order.pop() + 1); print(" ")
        }
    }
}
