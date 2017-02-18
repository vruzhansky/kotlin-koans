package v_builders

import util.TODO
import util.doc39
import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask39(): Nothing = TODO(
    """
        Task 39.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can run the 'Html Demo' configuration in IntelliJ IDEA to see the rendered table.
    """,
    documentation = doc39()
)

fun renderProductTable(): String {
    return html {
        table {
            tr(color = getTitleColor()) {
                td(color = getTitleColor()) {
                    text("Product")
                }
                td(color = getTitleColor()) {
                    text("Price")
                }
                td(color = getTitleColor()) {
                    text("Popularity")
                }
            }

            var i = 0
            getProducts().forEach {
                tr(color = getTitleColor()) {
                    td(color = getCellColor(i, 0)) { text(it.description) }
                    td(color = getCellColor(i, 1)) { text(it.price) }
                    td(color = getCellColor(i, 2)) { text(it.popularity) }
                    i++
                }
            }
        }
    }.toString()
}
