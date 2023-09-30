open class Hero(
    open var hp: Int, //gibt Healthpoints an
    var manaOrRecource: Int, //gibt an welche Recource verwendet wird: Mana, Wut, Energy und Menge
    var strg: Double, // Gibt den Stärkewert eines Characters an
    var int: Double, // Gibt den Intilligenzwert eines Characters an
    var agi: Double, // Gibt den Beweglichkeitswert eines Charakers an
    open var pDef: Int, // Gibt die physische Defensive eines Characters an
    open var mDef: Int, // Gibt die magische Defensive eines Characters an
    open val name: String, // Name des Characters
    var threat: Int, // gibt an wie hoch die "Aggro" des Characters ist und wie hoch die chance ist von Ragnaros angegriffen zu werden
    var dotActive: Boolean // gibt an ob der Character unter einem damage over timer Effekt leidet oder nicht
) {
    /*var inventoryVariable: Map<Int, String> = mapOf(
        1 to "Heal Potion",
        2 to "STR Buff- Potion",
        3 to "AGI Buff-Potion",
        4 to "INT Buff- Potion"
    )
    */
    open fun rogueAction1(): Double {
        var attacke1 = 100..250
        var dmg = attacke1.random().toDouble()
        println("$name setzt $attacke1 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    open fun rogueAction2(): Double {
        var attacke2 = 100..250
        var dmg = attacke2.random().toDouble()
        println("$name setzt $attacke2 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    open fun rogueAction3(): Double {
        var attacke3 = 100..250
        var dmg = attacke3.random().toDouble()
        println("$name setzt $attacke3 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    open fun rogueAction4(): Double {
        var attacke4 = 100..250
        var dmg = attacke4.random().toDouble()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    open fun spAction1(): Double {
        var attacke4 = 100..250
        var dmg = attacke4.random().toDouble()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    open fun spAction2() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }

    open fun spAction3() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }

    open fun spAction4() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }

    open fun tankAction1() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }

    open fun tankActiion2() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }

    open fun tankAction3(): Double {
        var attacke4 = 100..250
        var dmg = attacke4.random().toDouble()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    open fun tankAction4(): Double {
        var attacke4 = 100..250
        var dmg = attacke4.random().toDouble()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }

    //open var inventoryList: MutableList<String> = mutableListOf("Health Potion", "STRG Potion", "AGI Potion", "INT Potion")

    open fun useInventory() {
        var input = readln().toInt()
        when (input) {
            1 -> {
                hp += 500
                inventoryList.removeAt(0)
                println("$name hat seine Lebenspunkte permanent um 50 erhöht!")

            }

            2 -> {
                strg += 50
                inventoryList.removeAt(1)
                println("$name hat seine Stärke permanent um 50 erhöht!")

            }

            3 -> {
                agi += 50
                inventoryList.removeAt(2)
                println("$name hat seine Beweglichkeit permanent um 50 erhöht!")
            }

            4 -> {
                int += 50
                inventoryList.removeAt(3)
                println("$name hat seine Intelligenz permanent um 50 erhöht!")

            }
            else -> {
                println("Ungültige Eingabe!")
            }
        }

    }
    /* open fun inventory(){
     when (inventoryVariable){
     }
     */
}
