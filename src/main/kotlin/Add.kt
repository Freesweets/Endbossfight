open class Add(
    hp: Double,
    strg: Int,
    int: Int,
    agi: Int,
    name: String,
    var explosive: Boolean
) : Enemy(hp, strg, int, agi, name) {
    val randomList: List<Boolean> = listOf(true, false) // Hilfe durch AI an in dieser Zeile
    fun attack(hero: Hero) {
        var angriff = 1..3
        var dmg = angriff.random() * strg * agi * int
        println("$name schlägt zu und verursacht $dmg Schaden an ${hero.name}")
        explosive = randomList.random()
        if (explosive == true){
            hp = 0.0
            hero.hp -= 350
            println("$name verursacht 350 Schaden an allen Helden")
        }

    }

}