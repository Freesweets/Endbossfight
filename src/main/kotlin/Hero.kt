open class Hero(
    var hp: Int, //gibt Healthpoints an
    var manaOrRecource: Pair<String, Int>, //gibt an welche Recource verwendet wird: Mana, Wut, Energy und Menge
    val rolle: String, // Gibt Rolle an Tank/Healer/DPS
    val waffentyp: Pair<String, String>, // Waffenart: z.B 1H Schwert, Stab, Dolch, 2H Hammer usw...
    val whatKindOfDmg: String, // Fire, Frost, Arcane, Holy, Bleed, Poison usw...
    var strg: Double, // Gibt den Stärkewert eines Characters an
    var int: Double, // Gibt den Intilligenzwert eines Characters an
    var agi: Int, // Gibt den Beweglichkeitswert eines Charakers an
    var pDef: Double, // Gibt die physische Defensive eines Characters an
    var mDef: Double, // Gibt die magische Defensive eines Characters an
    val name: String, // Name des Characters
    val classAndSpec: String // Gibt die Klasse und Speziallisierung des Characters an zB. Subtility-Rogue, Fire-Mage usw
) {
    open fun attack1() {
        var attacke1 = 100..250
        var dmg = attacke1.random()
        println("$name setzt $attacke1 ein und fügt Ragnaros $dmg zu!")
    }

    open fun attack2() {
        var attacke2 = 100..250
        var dmg = attacke2.random()
        println("$name setzt $attacke2 ein und fügt Ragnaros $dmg zu!")
    }

    open fun attack3() {
        var attacke3 = 100..250
        var dmg = attacke3.random()
        println("$name setzt $attacke3 ein und fügt Ragnaros $dmg zu!")
    }

    open fun attack4() {
        var attacke4 = 100..250
        var dmg = attacke4.random()
        println("$name setzt $attacke4 ein und fügt Ragnaros $dmg zu!")
    }

}