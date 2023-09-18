class Minion(
    hp: Int,
    whatKindOfDmg: String,
    strg: Int,
    int: Int,
    agi: Int,
    pDef: Int,
    mDef: Int,
    name: String,
    type: String,
    var explode: Boolean
) : Enemy(hp, whatKindOfDmg, strg, int, agi, pDef, mDef, name, type) {
}