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
    thread: Int,
    classAndSpec: String,
    var dot: Boolean, //Wird zu begin der Runde gecheckt. Falls true dann erleidet der Character entsprechend Schaden. Default false, wird durch Boss attac getriggert
    val meele: Boolean, // Gibt an ob der Character Nahkämpfer ist oder nicht
    val physicalOrMagic: Char // Gibt an ob der Character physische oder magische Angriffe ausführt
) : Hero(
    hp,
    manaOrRecource,
    rolle,
    waffentyp,
    whatKindOfDmg,
    strg,
    int,
    agi,
    pDef,
    mDef,
    name,
    thread,
    classAndSpec
) { // Hero vererbt seine Eigenschaften an Klasse
    var ssUsed: Boolean = false

    override fun attack1() {
        val attackName = "Sinister Strike"
        var sinisterStrige = 12..18
        var dmg = sinisterStrige.random() * agi
        println("$name fügt Ragnaros mit ${attackName}, $dmg Schaden zu!")
        ssUsed = true
    }

    override fun attack2() {
        if (ssUsed == true) {
            var ambush = 15..20
            var dmg = ambush.random() * agi
            println("$name fügt Ragnaros $dmg zu!")
            ssUsed = false
        }
        else {
            var ambush = 15..20
            var dmg = ambush.random() * strg
            println("$name fügt Ragnaros $dmg zu!")
        }
    }

    override fun attack3() {
        val attackName = "Shadow Strike"
        var shadowStrike = 10..22
        var dmg = shadowStrike.random() * int
        println("$name fügt Ragnaros $dmg zu!")
    }

    override fun attack4() {
        val attackName = "Tricks of the trade"
        var tricksOfTheTrade = 1..7
        var dmg = tricksOfTheTrade.random() * agi
        thread --
        thread
    }
}