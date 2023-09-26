class Tank(
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
    var newThread = thread
    fun isAlive(): Boolean {
        return hp > 0
    }
    var newRage = manaOrRecource
    override fun tankAction1() { // Thread increase Ability
        val attackName = "Taunt"
       // thread = 100 // setzt Thread des Heros auf 100
       // newThread = thread + 100
        newRage += 15 // erhöht die Wut des Characters um 15 nach einsetzten der Ability
        println("$name setzt $attackName ein und erhöht seinen Thread auf 100!")
        println("$name´s Wut steigt um 15 und beträgt nun ${newRage}")
    }

    override fun tankActiion2() { //Heal def cd Ability
        val attackName = "Last man standing"
        if (hp < 2500 || manaOrRecource == 50) { //bedingung zum einsetzten der Ability ist dass der Hero weniger als 2,5k hp hat und mehr als 50 Wut
            hp = 7800 // setzt die HP des Heros auf den festgelegten Wert
            println("$name setzt $attackName ein um sich wieder auf 100% zu heilen")
            manaOrRecource - 50 // verbraucht Wut als recource
        } else {
            println("Du hast nicht genügend Schaden erlitten oder nicht genung Wut um diese Ability einzusetzten!")
        }
    }

    override fun tankAction3(): Double { //Simple damage Ability mit Strengh Multiplikator
        val attackName = "Heroic Strike"
        var heroicStrike = 15..18
        var dmg = heroicStrike.random().toDouble() * strg
        manaOrRecource + 15
        println("$name setzt $attackName ein und fügt Ragnaros $dmg zu")
        return dmg
    }

    override fun tankAction4(): Double { // AE Ability (Area Effect) die dmg verursacht mit agi und int Multiplikator
        val attackName = "Thunderclap"
        var thunderclap = 1..2
        var dmg = thunderclap.random().toDouble() * agi * int
        manaOrRecource + 20 // erhöht den Thread des Heros um 20
        println("$name setzt $attackName ein verursacht damit $dmg an allen Gegnern")
        return dmg
    }
}
