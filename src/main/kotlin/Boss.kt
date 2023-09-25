class Boss(
    hp: Double,
    strg: Int,
    int: Int,
    agi: Int,
    name: String,
    var recource: Int
) : Enemy(hp, strg, int, agi, name) {
    var newRecource = recource
    var empoweredSulfuras = false
    var abgetaucht = false
    fun isAlive(): Boolean {
        return hp > 0
    }

    override fun enemyAction1(hero: Hero) { //Simple damage Action
        val attackName = "Lava Burst"
        var lavaBurst = 1..5
        var dmg = (lavaBurst.random() * int) /2
        newRecource + 15 //nach einsatz der Ability wird die Recource um 15 erhöht
        println("Ragnaros setzt $attackName ein und fügt damit ${hero.name} $dmg Schaden zu")
        hero.hp -= dmg
    }

    override fun enemyAction2(hero: Hero) {
        val attackName = "Blast Wave"
        var blastWave = 3..8
        var dmg = (blastWave.random() * int) / 2
        newRecource + 10
        println("Ragnaros setzt $attackName ein und fügt damit ${hero.name} $dmg Schaden zu")
        hero.hp -= dmg
    }

    override fun enemyAction3(hero: Hero) { // Wenn empoweredSulfuras false ist dann wird es auf true gesetzt
        val attackName = "Empower Sulfuras"
        if (empoweredSulfuras == false) {
            empoweredSulfuras == true
            println("Ragnaros setzt $attackName ein und verstärkt Sulfuras mit Lava! Nächste Runde wirds weh tun!")
            newRecource + 15
        }
        if (empoweredSulfuras == true) { // Sollte empoweredSulfuras bereits true sein, so wird ein mächtiger Angriff ausgeführt
            var lavaSulfuras = 4..10
            var dmg = (lavaSulfuras.random() * strg) / 2
            println("Ich hab euch gewarnt!")
            println("Raganaros fügt ${hero.name}, $dmg Schaden zu")
            newRecource + 15
            empoweredSulfuras = false // Setzt nach dem erfolgreichen Angriff empoweredSulfuras wieder auf false
            hero.hp -= dmg
        } //else {
            //println("EIN FEHLER IM CODE! Ich greif einfach noch mal an! HAHA")
        //}
    }

    override fun enemyAction4(hero: Hero) { // dot effect. Jede Runde erleidet der Hero Schaden
        val attackName = "Living Meteor"
        var livingMeteor = 20..80
        var dmg = livingMeteor.random() * 5
        println("Ragnaros setzt $attackName ein und fügt damit ${hero.name}, $dmg Schaden zu")
        newRecource + 15
        dot = true
        hero.hp -= dmg
    }

    override fun enemyAction5(hero: Hero) { // Taucht ab um sich zu schützen
        val attackName = "Abtauchen"
        if (abgetaucht == false) {
            println("Ragnaros saugt die Lava um Ihn herum auf")
            abgetaucht = true
            newRecource + 25
        } else if (abgetaucht == true) { // Falls bereits abgetaucht, erhöht die Stats strg und int um jeweils 10
            println("Ragnaros entlädt seine Energie und erhöht seine Stärke und Initligenz um 100")
            abgetaucht = false // setzt abgetaucht wieder auf false
            strg + 100
            int + 100
            newRecource + 25
        }
    }

    override fun enemyAction6(hero: Hero) { // Einsetztbar wenn Boss Recource 100 oder mehr erreicht. Verursacht viel schaden in einer großen range für alle Heros
        val attackName = "Wrath of Ragnaros"
        if (newRecource >= 100) {
            println("FEEL MY WRATH!")
            var wrathOfRagnaros = 3..10
            var dmg = (wrathOfRagnaros.random() * strg * int) / 3
            println("Ragnaros fügt ALLEN Helden $dmg Schaden mit $attackName zu!")
            var newHp = hero.hp - dmg
            hero.hp = newHp
        } else {
            println("EIN FEHLER IM CODE! Ich greif einfach noch mal an! HAHA")
            val attackName = "Lava Burst"
            var lavaBurst = 1..5
            var dmg = (lavaBurst.random() * int) /2
            newRecource + 15 //nach einsatz der Ability wird die Recource um 15 erhöht
            println("Ragnaros setzt $attackName ein und fügt damit ${hero.name} $dmg Schaden zu")
            hero.hp -= dmg
        }
    }

    open var bossActionList = listOf<(Hero) -> Any>(
        { hero: Hero -> enemyAction1(hero) },
        { hero: Hero -> enemyAction2(hero) },
        { hero: Hero -> enemyAction3(hero) },
        { hero: Hero -> enemyAction4(hero) },
        { hero: Hero -> enemyAction5(hero) },
        { hero: Hero -> enemyAction6(hero) }
    )
    /*var testLambda = {
        hero : Hero ->
            val attackName = "Wrath of Ragnaros"
            if(newRecource >= 100){
                println("FEEL MY WRATH!")
                var wrathOfRagnaros = 3..10
                var dmg = (wrathOfRagnaros.random() * strg * int) /18
                println("Ragnaros fügt ALLEN Helden $dmg Schaden mit $attackName zu!")
                dmg
            }else {
                println("EIN FEHLER IM CODE! Ich greif einfach noch mal an! HAHA")
                enemyAction1(hero)
            }


     */
}
