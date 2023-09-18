open class Enemy(var hp: Int,
    val whatKindOfDmg: String,
    var strg: Int,
    var int: Int,
    var agi: Int,
    protected var pDef: Int,
    protected var mDef: Int,
    val name: String,
    val type: String
) {
}