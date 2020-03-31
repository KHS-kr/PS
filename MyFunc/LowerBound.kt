fun lower_bound(arr : IntArray, start : Int, end : Int, n : Int) : Int {
    var left = start
    var right = end

    while(left < right) {
        val mid = (left + right) / 2
        if(mid == right)
            return right
        if(arr[mid] < n)
            left = mid + 1
        else
            right = mid
    }
    return left
}
