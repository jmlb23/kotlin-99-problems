package functions

fun <T> last(xs: List<T?>): T? = when (xs) {
    listOf<T>() -> null
    else -> xs[xs.size - 1]
}

fun <T> penultimate(xs: List<T?>): T? = when {
    xs.isEmpty() || xs.size == 1 -> null
    else -> xs[xs.size - 2]
}

fun <T> nth(n: Int, xs: List<T>): T? = if (xs.isEmpty() || n > xs.size) {
    null
} else when (n) {
    0 -> xs.first()
    else -> nth(n - 1, xs.drop(1))
}

tailrec fun <T> tail_length(xs:List<T>,n: Int): Int = when(xs){
    emptyList<Nothing>() ->  n
    else -> tail_length(xs.drop(1),n+1)
}

fun <T> length(xs: List<T>): Int = tail_length(xs,0)



fun <T> reverse(xs: List<T>): List<T?> = when (xs) {
    listOf<T>() -> listOf<T>()
    else -> listOf(last(xs)).union(reverse(xs.dropLast(1))).toList()
}

fun <T> isPalindrome(xs: List<T>): Boolean {
    fun helper(ys: List<T>): List<Boolean> = when {
        ys.size in 0..1 -> listOf(true)
        else -> listOf(ys.first() == ys.last()).union(helper(ys.drop(1).dropLast(1))).toList()
    }
    return helper(xs).all { x -> x }
}


fun flatten(xs: List<*>): List<*> = when (xs) {
    listOf<Nothing>() -> emptyList<Nothing>()
    else -> if (xs.first() is List<*>) {
        //estaba facendo un flatten da lista e asumindo que o do resto non era necesario
        flatten(xs.first() as List<*>) + flatten(xs.drop(1))
    } else listOf(xs.first()) + flatten(xs.drop(1))
}

fun <T> compress(xs: List<T>): List<T> =
    if (xs.isEmpty() || xs.size == 1) xs
    else {
        val first = xs.first()
        val second = xs.drop(1).first()
        val listByOne = xs.drop(1)
        if (first == second) compress(listByOne)
        else listOf(first) + compress(listByOne)
    }





