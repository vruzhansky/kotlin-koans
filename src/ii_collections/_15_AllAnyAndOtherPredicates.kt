package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)

    val allZeros: Boolean = list.all(isZero)

    val numberOfZeros: Int = list.count(isZero)

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
}

fun Customer.isFrom(city: City): Boolean = city == this.city

fun Shop.checkAllCustomersAreFrom(city: City): Boolean = this.customers.all { city == it.city }

fun Shop.hasCustomerFrom(city: City): Boolean = this.customers.any { city == it.city }

fun Shop.countCustomersFrom(city: City): Int = this.customers.count { city == it.city }

fun Shop.findAnyCustomerFrom(city: City): Customer? = this.customers.firstOrNull { city == it.city }
