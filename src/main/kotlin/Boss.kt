class Boss(
    hp: Int,
    whatKindOfDmg: String,
    strg: Int,
    int: Int,
    agi: Int,
    pDef: Int,
    mDef: Int,
    name: String,
    type: String,
    protected var recource: Int
) : Enemy(hp, whatKindOfDmg, strg, int, agi, pDef, mDef, name, type) {
    var newRecource = recource
    var empoweredSulfuras = false
    open var abgetaucht = false
    fun isAlive(): Boolean{
        return hp > 0
    }
    override fun enemyAction1() { //Simple damage Action
        val attackName = "Lava Burst"
        var lavaBurst = 1..5
        var dmg = (lavaBurst.random() * int) / 11
        newRecource + 15 //nach einsatz der Ability wird die Recource um 15 erhöht
        println("Ragnaros setzt $attackName ein und fügt damit ${name} $dmg Schaden zu")
    }

    override fun enemyAction2() {
        val attackName = "Blast Wave"
        var blastWave = 3..8
        var dmg = (blastWave.random() * int) / 10
        newRecource + 10
        println("Ragnaros setzt $attackName ein und fügt damit ${name} $dmg Schaden zu")
    }

    override fun enemyAction3() { // Wenn empoweredSulfuras false ist dann wird es auf true gesetzt
        val attackName = "Empower Sulfuras"
        if (empoweredSulfuras == false) {
            empoweredSulfuras == true
            println("Ragnaros setzt $attackName ein und verstärkt Sulfuras mit Lava! Nächste Runde wirds weh tun!")
            newRecource + 15
        } else if (empoweredSulfuras == true){ // Sollte empoweredSulfuras bereits true sein, so wird ein mächtiger Angriff ausgeführt
            var lavaSulfuras = 4..10
            var dmg = (lavaSulfuras.random() * strg) / 9
            println("Ich hab euch gewarnt!")
            println("Raganaros fügt $name, $dmg Schaden zu")
            newRecource + 15
            empoweredSulfuras = false // Setzt nach dem erfolgreichen Angriff empoweredSulfuras wieder auf false
        }
    }

    override fun enemyAction4() { // dot effect. Jede Runde erleidet der Hero Schaden
        val attackName = "Living Meteor"
        var livingMeteor = 20 .. 80
        var dmg = livingMeteor.random()
        println("Ragnaros setzt $attackName ein und fügt damit ${name}, $dmg Schaden zu")
        newRecource + 15
        dot = true
    }
    override fun enemyAction5() { // Taucht ab um sich zu schützen
        val attackName = "Abtauchen"
        if (abgetaucht == false){
            println("Ragnaros taucht in die Lava ein")
            abgetaucht = true
            newRecource + 25
        }else if(abgetaucht == true){ // Falls bereits abgetaucht, erhöht die Stats strg und int um jeweils 10
            println("Ragnaros kommt aus seinem Lava hervor mit neuer Energie")
            abgetaucht = false // setzt abgetaucht wieder auf false
            strg + 10
            int + 10
            newRecource + 25
        }
    }
    override fun enemyAction6() { // Einsetztbar wenn Boss Recource 100 oder mehr erreicht. Verursacht viel schaden in einer großen range für alle Heros
        val attackName = "Wrath of Ragnaros"
        if (newRecource >= 100){
            println("FEEL MY WRATH!")
            var wrathOfRagnaros = 3..10
            var dmg = (wrathOfRagnaros.random() * strg * int) /18
            println("Ragnaros fügt ALLEN Helden $dmg Schaden mit $attackName zu!")
        }
    }
}