open class Enemy(
    var hp: Double,
    var strg: Int,
    var int: Int,
    var agi: Int,
    val name: String
) {
    open fun enemyAction1(hero: Hero) {
        val attackName = "Attack 1"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        hero.hp -= dmg
    }

    open fun enemyAction2(hero: Hero){
        val attackName = "Attack 2"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        hero.hp -= dmg
    }

    open fun enemyAction3(hero: Hero) {
        val attackName = "Attack 3"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        hero.hp -= dmg
    }

    open fun enemyAction4(hero: Hero) {
        val attackName = "Attack 4"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        hero.hp -= dmg
    }

    open fun enemyAction5(hero: Hero) {
        val attackName = "Attack 5"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
    }

    open fun enemyAction6(hero: Hero) {
        val attackName = "Attack 6"
        var attack1 = 1..10
        var dmg = attack1.random() * agi
        hero.hp -= dmg
    }
}