open class Hero(
    var hp: Int, //gibt Healthpoints an
    var manaOrRecource: Int, //gibt an welche Recource verwendet wird: Mana, Wut, Energy und Menge
    val rolle: String, // Gibt Rolle an Tank/Healer/DPS
    val waffentyp: Pair<String, String>, // Waffenart: z.B 1H Schwert, Stab, Dolch, 2H Hammer usw...
    val whatKindOfDmg: String, // Fire, Frost, Arcane, Holy, Bleed, Poison usw...
    var strg: Double, // Gibt den Stärkewert eines Characters an
    var int: Double, // Gibt den Intilligenzwert eines Characters an
    var agi: Double, // Gibt den Beweglichkeitswert eines Charakers an
    var pDef: Double, // Gibt die physische Defensive eines Characters an
    var mDef: Double, // Gibt die magische Defensive eines Characters an
    open val name: String, // Name des Characters
    var thread: Int, // gibt an wie hoch die "Aggro" des Characters ist und wie hoch die chance ist von Ragnaros angegriffen zu werden
    val classAndSpec: String // Gibt die Klasse und Speziallisierung des Characters an zB. Subtility-Rogue, Fire-Mage usw
) {
    open fun rogueAction1() {
        var attacke1 = 100..250
        var dmg = attacke1.random()
        println("$name setzt $attacke1 ein und fügt Ragnaros $dmg zu!")
    }

    open fun rogueAction2() {
        var attacke2 = 100..250
        var dmg = attacke2.random()
        println("$name setzt $attacke2 ein und fügt Ragnaros $dmg zu!")
    }

    open fun rogueAction3() {
        var attacke3 = 100..250
        var dmg = attacke3.random()
        println("$name setzt $attacke3 ein und fügt Ragnaros $dmg zu!")
    }

    open fun rogueAction4() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }
    open fun spAction1() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
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
}