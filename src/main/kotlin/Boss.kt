class Boss(
    hp: Int,
    whatKindOfDmg: String,
    strg: Int,
    int: Int,
    agi: Int,
    pDef: Int,
    mDef: Int,
    name: String,
    type: String,
    protected var recource: Pair<String, Int>
) : Enemy(hp, whatKindOfDmg, strg, int, agi, pDef, mDef, name, type) {

}