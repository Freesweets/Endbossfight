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
    open fun enemyAction1 (){
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }
    open fun enemyAction2 (){
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }
    open fun enemyAction3 (){
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }
    open fun enemyAction4 (){
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }
    open fun enemyAction5 (){
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }
    open fun enemyAction6 (){
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }


}