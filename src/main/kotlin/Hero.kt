open class Hero(
    var hp: Int, //gibt Healthpoints an
    var manaOrRecource: Int, //gibt an welche Recource verwendet wird: Mana, Wut, Energy und Menge
    var strg: Double, // Gibt den Stärkewert eines Characters an
    var int: Double, // Gibt den Intilligenzwert eines Characters an
    var agi: Double, // Gibt den Beweglichkeitswert eines Charakers an
    var pDef: Double, // Gibt die physische Defensive eines Characters an
    var mDef: Double, // Gibt die magische Defensive eines Characters an
    open val name: String, // Name des Characters
    var thread: Int, // gibt an wie hoch die "Aggro" des Characters ist und wie hoch die chance ist von Ragnaros angegriffen zu werden
) {
    var inventoryVariable: Map<Int, String> = mapOf(
        1 to "Heal Potion",
        2 to "STR Buff- Potion",
        3 to "AGI Buff-Potion",
        4 to "INT Buff- Potion"
    )
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
    open fun spAction3()  {
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
    open fun tankAction3() : Double {
        var attacke4 = 100..250
        var dmg = attacke4.random().toDouble()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }
    open fun tankAction4() :Double {
        var attacke4 = 100..250
        var dmg = attacke4.random().toDouble()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
        return dmg
    }
    open fun inventory(){
    when (inventoryVariable){

    }

    }
}