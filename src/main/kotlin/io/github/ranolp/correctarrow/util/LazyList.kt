package io.github.ranolp.correctarrow.util

class LazyList<T>(override val size: Int, private val lazyInitializer: (Int) -> T,
        private val setter: (Int, T?) -> T? = { _, _ -> throw UnsupportedOperationException() }) : MutableList<T?> {
    private val map: MutableMap<Int, T> = mutableMapOf()

    override fun contains(element: T?): Boolean = map.containsValue(element)

    override fun containsAll(elements: Collection<T?>): Boolean = elements.all(this::contains)

    override fun get(index: Int): T = map.getOrPut(index, { lazyInitializer(index) })

    override fun indexOf(element: T?): Int = map.filter { it.value == element }.keys.firstOrNull() ?: -1

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun iterator(): MutableIterator<T?> = full().iterator()

    override fun lastIndexOf(element: T?): Int = map.filter { it.value == element }.keys.lastOrNull() ?: -1

    override fun listIterator(): MutableListIterator<T?> = full().listIterator()

    override fun listIterator(index: Int): MutableListIterator<T?> = full().listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T?> = full().subList(fromIndex, toIndex)

    private fun full(): MutableList<T?> = MutableList<T?>(size, map::get)

    override fun add(element: T?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun add(index: Int, element: T?) {
        throw UnsupportedOperationException()
    }

    override fun addAll(index: Int, elements: Collection<T?>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun addAll(elements: Collection<T?>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun clear() {
        throw UnsupportedOperationException()
    }

    override fun remove(element: T?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeAll(elements: Collection<T?>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeAt(index: Int): T? {
        throw UnsupportedOperationException()
    }

    override fun retainAll(elements: Collection<T?>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun set(index: Int, element: T?): T? {
        return setter(index, element)
    }
}