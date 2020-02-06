class Solution {
    fun solution(n: Int): IntArray {
        val arrBig = Array(n + 1) { mutableListOf<Int>() }
        arrBig[0].add(0)
        for(i in 1 until arrBig.size) {
            println(i)
            var onetwo = true
            for(j in 0 until Math.pow(2.0, i.toDouble()).toInt() - 1) {
                if(j % 2 == 1)
                    arrBig[i].add(arrBig[i - 1][j / 2])
                else
                    arrBig[i].add(if(onetwo) {onetwo = false; 0} else { onetwo = true; 1})
            }
        }

        return arrBig[n].toIntArray()
    }
}
