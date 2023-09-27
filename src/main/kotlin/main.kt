fun main() {

    var hero1: Tank = Tank(
        5800,
        0,
        68.0,
        15.0,
        25.0,
        400,
        230,
        "Schanzentor",
        0,
        false
    )

    var hero2: Rogue = Rogue(
        3200,
        150,
        40.0,
        35.0,
        95.0,
        225,
        150,
        "Verox",
        0,
        false,
        'P'
    )

    var hero3: Priest = Priest(
        2800,
        2500,
        10.0,
        98.0,
        12.0,
        130,
        200,
        "Stardusk",
        0,
        false
    )

    var boss: Boss = Boss(
        25000.0,
        420,
        420,
        420,
        "Ragnaros the Firelord",
        0
    )

    var group: MutableList<Hero> = mutableListOf(hero1, hero2, hero3)
    var round = 1
    var gameOver = false

    fun spAction3() { // diese Ability schützt das gewählte Ziel vor dem nächsten Angriff des Bosses
        println("Auf wen willst du Flash Heal einsetzten? 1 -> Tank, 2 -> Rogue, 3 -> Priest")
        hero3.manaOrRecource -= 100
        hero3.thread += 25
        when (readln().toIntOrNull()) {
            1 -> hero1.hp += 500
            2 -> hero2.hp += 500
            3 -> hero3.hp += 500
            else -> {
                println("Bitte wiederhole deine Eingabe. Das hat dich 150 Mana gekostet")
                spAction3()
            }
        }
    }

    fun spAction4() { // DoT (damage over time) remove
        println("Von wem möchtest du den DoT entfernen?")
        hero3.manaOrRecource -= 250
        hero3.thread += 25
        when (readln().toIntOrNull()) {
            1 -> hero1.dotActive = false
            2 -> hero2.dotActive = false
            3 -> hero3.dotActive = false
            else ->
                println("Bitte wiederhole deine Eingabe. Das hat dich 150 Mana gekostet")
        }
    }


    fun bossAttackRandom(): (Hero) -> Any { //greift auf eine zufällige Aktion des Bosses zu und führt diese aus
        var action = boss.bossActionList.random()
        return action
    }

    fun chooseTarget(): Hero { //bestimmt das Ziel des Angriffes. Das Ziel ist immer der Hero mit dem höchstes Thread Wert
        var target = group.maxBy { it.thread } // Danke Max!
        /* if (hero1.thread > hero2.thread && hero1.thread > hero3.thread) {
             return hero1
         } else if (hero2.thread > hero1.thread && hero2.thread > hero3.thread) {
             return hero2
         } else {
             return hero3
         }
         Test Schleife- Danke Okan!
         */
        return target
    }

    var bossAttacke = bossAttackRandom()
    fun extraMove() { // Jede Runde würfelt der Boss. Mit einer 10%igen Chance einen weiteren Angriff auszuführen
        var dice = 1..10
        var wurf = dice.random()
        if (wurf == 1) { // 10% Chance
            println("YOU FOOL! You thought there are rules in this GAME?! NOT FOR ME!")
            bossAttacke(chooseTarget())
        }
    }
    println("""
        Alle Heros basieren auf echten Charakteren von Freunden aus dem Spiel World of Warcraft...
        "Schanzentor" ist ein Tank. Diese halten zwar viel Schaden aus, verursacht jedoch selbst relativ geringen Schaden.
        "Verox" ist ein Schurke. Seine Angriffe bauen aufeinander auf und verursachen viel Schaden.
        "Stardusk" ist ein Schatten Priester. Zwar verursacht er moderaten Schaden, kann aber auch seine Gruppenmitglieder mit seinen Fähigkeiten unterstützen.
        -------------------------------------------------------------------------------------------------------------------------------------------------------
    """.trimIndent())
    Thread.sleep(2000)
    println( //println zu Begninn des Spiels
        """
        Die 3 Helden haben sich bis zu Ragnaros dem Feuerlord vorgekämpft. 
        Majordomus Exekutus sieht die Helden in der Ferne. Aus Panik versucht er Ragnaros zu beschwören bevor es zu spät ist...
        Ragnaros: TOO SOON!! YOU SUMMONED ME TOO SOON!! YOU WILL DIE FOR YOUR MUSTAKES MAJORDOMUS!
        Ragnaros erschlägt Majordomus mit Sulfuras und wendet sich den Helden zu....
        -------------------------------------------------------------------------------------------------------------------------------------------------------
    """.trimIndent()
    )
    Thread.sleep(3000)

    while (gameOver == false) { //readln Optionen für den Spieler
        println("${hero1.name}: ${hero1.hp} HP / ${hero1.manaOrRecource} Wut / ${hero1.thread} Bedrohung")
        println("Wähle eine Tank Aktion aus...")
        var warriorInput: Int? = null
        println(
            """
            Tank Aktionen:
            1 -> Taunt (erhöht deinen Thread und erzeugt 15 Wut)
            2 -> Last man standing (Verbraucht 50 Wut oder ist kostenlos falls deine HP unter 2500 liegt. Heilt dich auf 7800 HP)
            3 -> Heroic Strike (verursacht moderaten Schaden und erzeugt 15 Wut)
            4 -> Thunderclap (verursacht moderaten Schaden an allen Gegnern und erzeugt 20 Wut)
            -------------------------------------------------------------------------------------------------------------------------------------------------------

        """.trimIndent()
        )
        warriorInput = readln().toIntOrNull()
        if (warriorInput == 1) { //Aktion des Spilers
            hero1.tankAction1()
        } else if (warriorInput == 2) {
            hero1.tankActiion2()
        } else if (warriorInput == 3) {
            boss.hp = boss.hp - hero1.tankAction3()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (warriorInput == 4) {
            boss.hp = boss.hp - hero1.tankAction4()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } /*else if (warriorInput == 5) {
            hero1.inventory()
            */
        else {
            warriorInput = null

        }
        //Bedingungen für das abschliessen des Spiels
        println("${hero2.name}: ${hero2.hp} HP / ${hero2.manaOrRecource} Energie / ${hero2.thread} Bedrohung")
        println("Wähle eine Rogue Aktion aus...")
        println(
            """
            Rogue Aktionen:
            1 -> Sinister Stiker (verursacht moderaten Schaden. Koster 15 Energy)
            2 -> Ambush (verursacht hohen Schaden. Der angerichtete Schaden wird erhöht falls in der Runde zuvor Sinister Strike eingesetzt wurde: WOMBO COMBO! - Kostet 25 Energy)
            3 -> Shadow Strike (hoher Schaden. Setzt verursachten Schaden von physisch zu magisch und vice versa. Sollte der Schaden bereits auf magisch eingestellt sein- verursacht Shadow Strike Bonusschaden und kostet keine Energy)
            4 -> Tricks of the trade (geringer Schaden. Reduziert den Thread des Rogues und erhöht den Thread des Tanks)
            -------------------------------------------------------------------------------------------------------------------------------------------------------
        """.trimIndent()
        )
        var rogueInput: Int? = readln().toIntOrNull() // Aktion des Spielers
        if (rogueInput == 1) { //Aktion des Spilers
            boss.hp = boss.hp - hero2.rogueAction1()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (rogueInput == 2) {
            boss.hp = boss.hp - hero2.rogueAction2()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (rogueInput == 3) {
            boss.hp = boss.hp - hero2.rogueAction3()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (rogueInput == 4) {
            boss.hp = boss.hp - hero2.rogueAction4()
            hero1.thread += 20
            println("${boss.name} hat noch ${boss.hp} übrig.")
            println("neuer Bedrohungswert des Tanks: ${hero1.thread}. Neuer Bedrohungswert des Schurken: ${hero2.thread} ")
            /*else if (rogueInput == 5) {
            hero2.inventory()
        }*/

        } else {
            rogueInput = null
        }
        println("${hero3.name}: ${hero3.hp} HP / ${hero3.manaOrRecource} Mana / ${hero3.thread} Bedrohung")
        Thread.sleep(1000)
        println("Wähle eine Priest Aktion aus...")
        println(
            """
            Priest Aktionen:        
            1 -> Mind Blast (hoher Schaden. Kostet 250 Mana)
            2 -> Fade (reduziert den Thread des Priesters auf 0)
            3 -> Flash Heal (wählt ein Gruppenmitglied aus. Das gewählte Ziel erhält 500 HP.)
            4 -> Dispel (entfernt einen damage over time Effekt von dem gewählten Ziel)
            -------------------------------------------------------------------------------------------------------------------------------------------------------
        """.trimIndent()
        )
        var priestInput: Int? = readln().toIntOrNull()  //Aktion des Spilers
        if (priestInput == 1) { //Aktion des Spilers
            boss.hp = boss.hp - hero3.spAction1()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (priestInput == 2) {
            hero3.spAction2()
        } else if (priestInput == 3) {
            spAction3()
        } else if (priestInput == 4) {
            spAction4()
        } else {
            priestInput = null
        }
        if (hero2.manaOrRecource < 150) {
            hero2.manaOrRecource += 10 // Schurken Energie wird jede Runde erhöht wenn Sie nicht bereits ihr maximum von 150 erreicht hat
        }
        if (hero3.manaOrRecource < 2500) { // Priester Mana wird jede runde erhöht wenn es nicht bereits sein maximum von 2500 erreicht hat
            hero3.manaOrRecource += 100
        }
        println("""
        -------------------------------------------------------------------------------------------------------------------------------------------------------
        Ragnaros ist am Zug!
        ------------------------------------------------------------------------------------------------------------------------------------------------------

        """.trimIndent())
        if (hero1.dotActive == true) { // DoT Effekt logik
            hero1.hp -= 150
            println("${hero1.name} hat 150 Schaden durch den DoT-Effekt erhalten")
        }
        if (hero2.dotActive == true) {
            hero2.hp -= 150
            println("${hero2.name} hat 150 Schaden durch den DoT-Effekt erhalten")
        }
        if (hero3.dotActive == true) {
            hero3.hp -= 150
            println("${hero3.name} hat 150 Schaden durch den DoT-Effekt erhalten")
        }
        if (boss.hp <= 0) { // Bedingungen für einen Sieg
            gameOver = true
            println("GEWONNEN")
        }
        if (hero1.hp <= 0 || hero2.hp <= 0 || hero3.hp <= 0) { // Bedingungen für eine Niederlage
            gameOver = true
            println("GAME OVER")
        }
        println("Ragnaros: LASS MICH NACHDENKEN!!")
        Thread.sleep(3000)
        bossAttacke(chooseTarget()) // Regulärer Boss move
        extraMove() // 10% chance auf einen weiteren move
        round++ // Rundenzähler
        println("$round. Runde")
    }
}