package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return if (this.year > other.year) 1
        else if (this.year == other.year && this.month > other.month) 1
        else if (this.year == other.year && this.month == other.month && this.dayOfMonth > other.dayOfMonth) 1
        else if (this.year == other.year && this.month == other.month && this.dayOfMonth == other.dayOfMonth) 0
        else -1
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        var current = start

        override fun hasNext(): Boolean = current <= endInclusive

        override fun next(): MyDate {
            val current = this.current
            this.current = current.nextDay()
            return current
        }
    }
}
