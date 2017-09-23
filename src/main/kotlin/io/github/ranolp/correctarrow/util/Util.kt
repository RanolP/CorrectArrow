package io.github.ranolp.correctarrow.util

fun String?.toSafeInt(default: Int = 0): Int {
    if (this != null && this.isNotEmpty()) {
        val numeric = this.filter { it in '0'..'9' }
        return if (numeric == this) numeric.toInt() else numeric.toSafeInt(default)
    }
    return default
}