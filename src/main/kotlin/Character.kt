class Character(
    hp: Int,
    manaOrRecource: Int,
    rolle: String,
    waffentyp: Pair<String, String>,
    whatKindOfDmg: String,
    strg: Double,
    int: Double,
    agi: Double,
    pDef: Double,
    mDef: Double,
    name: String,
    thread: Int,
    classAndSpec: String,
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
    var ssUsed: Boolean =
        false // ein boolinischer Wert der besagt ob die Ability "Sinister Stike" eingesetzt wurde oder nicht. Default false
    var newManaValue = manaOrRecource
    var newThread = thread
    fun isAlive(): Boolean{
        return hp > 0
    }

    override fun rogueAction1() { // Damage Ability namens "Sinister Strike". Var ssUsed wird nach einsatz auf true gesetzt.
        val attackName = "Sinister Strike"
        var sinisterStrige = 12..18
        var dmg = sinisterStrige.random() * agi
        println("$name fügt Ragnaros mit ${attackName}, $dmg Schaden zu!")
        ssUsed = true
        newManaValue - 15 //recource cost
    }

    override fun rogueAction2() { // Combopoint spender like Ability. Verursacht deutlich mehr Schaden wenn in der Runde zuvor Sinister Strike eingesetzt wurde und setzt var ssUsed auf false nachdem Ambush eingesetzt wurde
        if (ssUsed == true && physicalOrMagic == 'P') {
            var ambush = 15..20
            var dmg =
                ambush.random() * agi + 50 //Schadensberechnung mit dem Agility Wert als Multiplikator. Die +50 kommen durch die Physical attack Bonus
            println("$name setzt Ambush ein und fügt Ragnaros $dmg zu!")
            ssUsed =
                false // der Combopoint wird quasi "verbraucht" und die var ssUsed wird auf false gesetzt. Dadurch wird ein erneutes einsetzten der Ability weniger dmg verursachen, es sei denn man setzt erneut vorher Sinister Strike ein
            newManaValue - 25 //recource cost
        } else {
            var ambush = 15..20
            var dmg =
                ambush.random() * strg // Schadenberechnung mit dem Strenght Wert als Multiplikator. Strenghvalue ist deutlich geringer als Agilityvalue. Dieser "else-Zweig" tritt nur ein wenn var ssUsed false ist
            println("$name setzt Ambush ein und fügt Ragnaros $dmg zu!")
            newManaValue - 25 //recource cost
        }
    }

    override fun rogueAction3() { //Einzige Rogue Ability die mit Intilligenz als Multiplikator arbeitet
        if (physicalOrMagic == 'M') { // Wenn der Rogue den Type Magic annimmt wird der verursachte Schaden um 250 erhöht
            val attackName = "Shadow Strike"
            var shadowStrike = 15..35 // große damage range da relativ geringer Multiplikator
            var dmg = shadowStrike.random() * int + 250
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue - 0 // Verbraucht keine Energy wenn Rogue nicht mehr physical angreifft
        } else if (physicalOrMagic == 'P') {
            val attackName = "Shadow Strike"
            var shadowStrike = 15..35 // große damage range da relativ geringer Multiplikator
            var dmg = shadowStrike.random() * int
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue - 10 //recource cost
        }
    }

    override fun rogueAction4() { //Rogue Ability die wenig Schaden verursacht, aber den Thread des Schurken um 5 reduziert und seinen Type von physical zu magic oder andersrum ändert
        if (physicalOrMagic == 'P') { // 'P' = Physical
            val attackName = "Tricks of the trade"
            var tricksOfTheTrade = 1..3
            var dmg = tricksOfTheTrade.random() * agi
            thread - 5 //Thread wird reduziert
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue - 5 //recource cost
            physicalOrMagic == 'M'
        } else if (physicalOrMagic == 'M') { // 'M' = Magic
            val attackName = "Tricks of the trade"
            var tricksOfTheTrade = 1..3
            var dmg = tricksOfTheTrade.random() * agi
            thread - 5 //Thread wird reduziert
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue - 5 //recource cost
            physicalOrMagic == 'P'
        }
    }

    override fun spAction1() {
        val attackName = "Mind Blast"
        var attacke4 = 18..22
        var dmg = attacke4.random() * int
        println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
        newManaValue - 250
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
            1 -> Character(
                6700,
                100,
                "Tank",
                "1H Axt" to "Schild",
                "Waffenschaden/Blutung",
                75.0,
                15.0,
                50.0,
                450.8,
                280.0,
                "Schanzentor",
                30,
                "Protection-Warrior",
                'P'
            )

            2 -> Character(
                4200,
                150,
                "DPS",
                "1H Schwert" to "Dolch",
                "Poison/Bleed/Shadow",
                40.0,
                35.0,
                95.0,
                235.5,
                150.5,
                "Verox",
                10,
                "Subtility-Rogue",
                'P'
            )

            3 -> Character(
                3800,
                2500,
                "DPS/Off-Heal",
                "Main-Hand" to "Off-Hand",
                "Shadow/Holy",
                10.0,
                98.0,
                12.0,
                130.8,
                200.69,
                "Stardusk",
                12,
                "Shadow-Priest",
                'M'
            )
            else -> {
                println("Bitte wiederhole deine Eingabe. Das hat dich 150 Mana gekostet")
                spAction3()
            }
        }
        println("$name setzt $attackName auf ${readln()} ein")
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

    override fun tankAction1() { // Thread increase Ability
        val attackName = "Taunt"
        thread == 100 // setzt Thread des Heros auf 100
        newManaValue + 15 // erhöht die Wut des Characters um 15 nach einsetzten der Ability
        println("$name setzt $attackName ein und erhöht seinen Thread auf 100!")
        println("$name´s Wut steigt um 10 und beträgt nun $newManaValue")
    }

    override fun tankActiion2() { //Heal def cd Ability
        val attackName = "Last man standing"
        if (hp < 2500 || manaOrRecource == 50) { //bedingung zum einsetzten der Ability ist dass der Hero weniger als 2,5k hp hat und mehr als 50 Wut
            hp = 7800 // setzt die HP des Heros auf den festgelegten Wert
            println("$name setzt $attackName ein um sich wieder auf 100% zu heilen")
            newManaValue - 50 // verbraucht Wut als recource
        } else {
            println("Du hast nicht genügend Schaden erlitten oder nicht genung Wut um diese Ability einzusetzten!")
        }
    }

    override fun tankAction3() : Double { //Simple damage Ability mit Strengh Multiplikator
        val attackName = "Heroic Strike"
        var heroicStrike = 15..18
        var dmg = heroicStrike.random() * strg
        newManaValue + 15
        println("$name setzt $attackName ein und fügt Ragnaros $dmg zu")
        return dmg
    }

    override fun tankAction4(): Double { // AE Ability (Area Effect) die dmg verursacht mit agi und int Multiplikator
        val attackName = "Thunderclap"
        var thunderclap = 1..2
        var dmg = thunderclap.random() * agi * int
        newManaValue + 20 // erhöht den Thread des Heros um 20
        println("$name setzt $attackName ein verursacht damit $dmg an allen Gegnern")
        return dmg
    }

}