class Character(
    hp: Int,
    manaOrRecource: Pair<String, Int>,
    rolle: String,
    waffentyp: Pair<String, String>,
    whatKindOfDmg: String,
    strg: Double,
    int: Double,
    agi: Int,
    pDef: Double,
    mDef: Double,
    name: String,
    classAndSpec: String,
    val meele: Boolean, // Gibt an ob der Character Nahkämpfer ist oder nicht
    val physicalOrMagic: Char // Gibt an ob der Character physische oder magische Angriffe ausführt
) : Hero(hp, manaOrRecource, rolle, waffentyp, whatKindOfDmg, strg, int, agi, pDef, mDef, name, classAndSpec) { // Hero vererbt seine Eigenschaften an Klasse

    override fun attack1() {
        val attackName = "Sinister Strike"
        var sinisterStrige = 12..18 * agi
        var dmg = sinisterStrige.random()
        println("$name fügt Ragnaros mit ${attackName}, $dmg Schaden zu!")
    }
    override fun attack2() {
        var ambush = 350..450
        var dmg = ambush.random()
        println("$name fügt Ragnaros $dmg zu!")
    }
}