class Rogue(
    hp: Int,
    manaOrRecource: Int,
    strg: Double,
    int: Double,
    agi: Double,
    pDef: Int,
    mDef: Int,
    name: String,
    thread: Int,
    dotActive: Boolean,
    val physicalOrMagic: Char // Gibt an ob der Character physische oder magische Angriffe ausführt
) : Hero(
    hp,
    manaOrRecource,
    strg,
    int,
    agi,
    pDef,
    mDef,
    name,
    thread,
    dotActive
) {
    var ssUsed: Boolean =
        false // ein boolinischer Wert der besagt ob die Ability "Sinister Stike" eingesetzt wurde oder nicht. Default false
    var newManaValue = manaOrRecource
    fun isAlive(): Boolean {
        return hp > 0
    }
    override fun rogueAction1(): Double { // Damage Ability namens "Sinister Strike". Var ssUsed wird nach einsatz auf true gesetzt.
        val attackName = "Sinister Strike"
        var sinisterStrige = 12..18
        var dmg = sinisterStrige.random().toDouble() * agi
        println("$name fügt Ragnaros mit ${attackName}, $dmg Schaden zu!")
        ssUsed = true
        newManaValue -= 15 //recource cost
        return dmg
    }

    override fun rogueAction2(): Double { // Combopoint spender like Ability. Verursacht deutlich mehr Schaden wenn in der Runde zuvor Sinister Strike eingesetzt wurde und setzt var ssUsed auf false nachdem Ambush eingesetzt wurde
        if (ssUsed == true) {
            var ambush = 25..30
            var dmg =
                ambush.random().toDouble() * agi + 50 //Schadensberechnung mit dem Agility Wert als Multiplikator. Die +50 kommen durch die Physical attack Bonus
            println("$name setzt Ambush ein und fügt Ragnaros $dmg zu!")
            ssUsed =
                false // der Combopoint wird quasi "verbraucht" und die var ssUsed wird auf false gesetzt. Dadurch wird ein erneutes einsetzten der Ability weniger dmg verursachen, es sei denn man setzt erneut vorher Sinister Strike ein
            newManaValue - 25 //recource cost
            return dmg
        } else {
            var ambush = 10..20
            var dmg =
                ambush.random().toDouble() * strg // Schadenberechnung mit dem Strenght Wert als Multiplikator. Strenghvalue ist deutlich geringer als Agilityvalue. Dieser "else-Zweig" tritt nur ein wenn var ssUsed false ist
            println("$name setzt Ambush ein und fügt Ragnaros $dmg zu!")
            newManaValue -= 25 //recource cost
            return dmg
        }
    }

    override fun rogueAction3(): Double { //Einzige Rogue Ability die mit Intilligenz als Multiplikator arbeitet
        if (physicalOrMagic == 'M') { // Wenn der Rogue den Type Magic annimmt wird der verursachte Schaden um 250 erhöht
            val attackName = "Shadow Strike"
            var shadowStrike = 15..35 // große damage range da relativ geringer Multiplikator
            var dmg = shadowStrike.random().toDouble() * int + 250
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue -= 0 // Verbraucht keine Energy wenn Rogue nicht mehr physical angreifft
            thread += 15
            return dmg
        } else   { // (physicalOrMagic == 'P')
            val attackName = "Shadow Strike"
            var shadowStrike = 15..35 // große damage range da relativ geringer Multiplikator
            var dmg = shadowStrike.random().toDouble() * int
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue -= 10 //recource cost
            thread += 15
            return dmg
        }
        //return rogueAction3()
    }
    override fun rogueAction4(): Double { //Rogue Ability die wenig Schaden verursacht, aber den Thread des Schurken um 5 reduziert und seinen Type von physical zu magic oder andersrum ändert
        if (physicalOrMagic == 'P') { // 'P' = Physical
            val attackName = "Tricks of the trade"
            var tricksOfTheTrade = 1..3
            var dmg = tricksOfTheTrade.random() * agi
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue -= 15 //recource cost
            physicalOrMagic == 'M'
            return dmg
        } else  { //(physicalOrMagic == 'M')'M' = Magic
            val attackName = "Tricks of the trade"
            var tricksOfTheTrade = 1..3
            var dmg = tricksOfTheTrade.random() * agi
            println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
            newManaValue -= 15 //recource cost
            physicalOrMagic == 'P'
            return dmg
        }//else return rogueAction4()
    }

}