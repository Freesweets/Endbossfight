open class Enemy(
    var hp: Double,
    var strg: Int,
    var int: Int,
    var agi: Int,
    val name: String
) {
    open fun enemyAction1(): Int {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        return dmg
    }

    open fun enemyAction2(): Int {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        return dmg
    }

    open fun enemyAction3(): Int {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        return dmg
    }

    open fun enemyAction4(): Int {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        return dmg
    }

    open fun enemyAction5() {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }

    open fun enemyAction6() : Int {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        return dmg
    }


}