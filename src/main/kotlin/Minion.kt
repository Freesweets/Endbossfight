class Minion(
    hp: Double,
    strg: Int,
    int: Int,
    agi: Int,
    name: String,
    var explode: Boolean
) : Enemy(hp, strg, int, agi, name) {
}