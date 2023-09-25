class Priest(
    hp: Int,
    manaOrRecource: Int,
    strg: Double,
    int: Double,
    agi: Double,
    pDef: Double,
    mDef: Double,
    name: String,
    thread: Int
) : Hero(
    hp,
    manaOrRecource,
    strg,
    int,
    agi,
    pDef,
    mDef,
    name,
    thread
) {
    var newManaValue = manaOrRecource
    var newThread = thread
    fun isAlive(): Boolean {
        return hp > 0
    }
    override fun spAction1():Double {
        val attackName = "Mind Blast"
        var attacke4 = 18..22
        var dmg = attacke4.random().toDouble() * int
        println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
        newManaValue - 250
        return dmg
    }

    override fun spAction2() { // reduziert den Thread des Heros auf 0
        val attackName = "Fade"
        newThread = 0
        println("$name setzt $attackName ein um seine Bedrohung auf 0 zu setzten")
        newManaValue - 150
    }

    override fun spAction3() { // diese Ability schützt das gewählte Ziel vor dem nächsten Angriff des Bosses
        println("Auf wen willst du Power Word: Shield einsetzten? 1 -> Tank, 2 -> Rogue, 3 -> Priest")
        val attackName = "Power Word: Shield"
        newManaValue - 150
        when (readln().toIntOrNull()) {
            1 -> Tank(
                7800,
                0,
                75.0,
                15.0,
                50.0,
                450.8,
                280.0,
                "Schanzentor",
                30
            )

            2 -> Rogue(
                4200,
                150,
                40.0,
                35.0,
                95.0,
                235.5,
                150.5,
                "Verox",
                10,
                'P'
            )

            3 -> Priest(
                3800,
                2500,
                10.0,
                98.0,
                12.0,
                130.8,
                200.69,
                "Stardusk",
                10
            )
            else -> {
                println("Bitte wiederhole deine Eingabe. Das hat dich 150 Mana gekostet")
                spAction3()
            }
        }
        println("$name setzt $attackName auf  ein")
    }

    override fun spAction4() { // DoT (damage over time) remove
        val attackName = "Mass Dispel"
        if (dot == true) { // wenn ein dot auf dem Hero liegt...
            dot == false // ...dann wird dieser entfernt
            println("$attackName hat den DoT dispel´t")
            newManaValue - 150
        } else {
            println("Es gibt keinen DoT Effekt zum dispelen!")
        }
    }
}