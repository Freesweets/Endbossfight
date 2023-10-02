class Priest(
    hp: Int,
    manaOrRecource: Int,
    strg: Double,
    int: Double,
    agi: Double,
    pDef: Int,
    mDef: Int,
    name: String,
    threat: Int,
    dotActive: Boolean
) : Hero(
    hp,
    manaOrRecource,
    strg,
    int,
    agi,
    pDef,
    mDef,
    name,
    threat,
    dotActive
) {

    override fun spAction1(): Double {
        val attackName = "Mind Blast"
        var attacke4 = 18..22
        var dmg = attacke4.random().toDouble() * int
        println("$name setzt $attackName ein und fügt Ragnaros $dmg zu!")
        manaOrRecource -= 250
        threat += 35
        return dmg
    }

    override fun spAction2() { // reduziert den threat des Heros auf 0
        val attackName = "Fade"
        if (threat > 0) {
            threat = 0
            println("$name setzt $attackName ein um seine Bedrohung auf 0 zu setzten")
            manaOrRecource -= 150
        } else {
            println("Deine Bedrohung beträgt bereits 0! Du hast deinen move verschwendet")
        }
    }

    override fun useInventory() {
        println(
            """
            Welchen Trank möchtest du benutzen?
            1 -> Health Potion (erhöht deine Lebenspunkte permanent um 500)
            2 -> STRG Potion (erhöht deine Stärke permanent um 50)
            3 -> AGI Potion (erhöht deine Beweglichkeit permanent um 50)
            4 -> INT Potion (erhöht deine Intelligenz permanent um 50)
            Nach benutzung eines Trankes verschwindet dieser aus deinem Inventar!
        """.trimIndent()
        )
        var input = readln().toIntOrNull()
        when (input) {
            1 -> {
                if ("Health Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Lebenspunkte permanent um 500 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    hp += 500
                    inventoryList.remove("Health Potion")
                } else println("Keine Health Potions mehr übrig...")

            }

            2 -> {
                if ("STRG Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Stärke permanent um 50 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    strg += 50
                    inventoryList.remove("STRG Potion")
                } else println("Keine STRG Potions mehr übrig...")

            }

            3 -> {
                if ("AGI Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Beweglichkeit permanent um 50 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    agi += 50
                    inventoryList.remove("AGI Potion")
                } else println("Keine AGI Potions mehr übrig...")
            }

            4 -> {
                if ("INT Potion" in inventoryList) {
                    println(
                        """
                        $name hat seine Intelligenz permanent um 50 erhöht!
                        -------------------------------------------------------------------------------------------------------------------------------------------------------
                    """.trimIndent()
                    )
                    int += 50
                    inventoryList.remove("INT Potion")
                } else println("Keine INT Potions mehr übrig...")

            }

            else -> {
                println("Ungültige Eingabe!")
            }
        }

    }
}

/* override fun spAction3() { // diese Ability schützt das gewählte Ziel vor dem nächsten Angriff des Bosses
     println("Auf wen willst du Power Word: Shield einsetzten? 1 -> Tank, 2 -> Rogue, 3 -> Priest")
     val attackName = "Power Word: Shield"
     newManaValue -= 150
     when (readln().toIntOrNull()) {
         1 -> Tank(
             7800,
             0,
             75.0,
             15.0,
             50.0,
             450.8,
             280.0,
             "Schanzentor",
             10,
             false
         )

         2 -> Rogue(
             4200,
             150,
             40.0,
             35.0,
             95.0,
             235.5,
             150.5,
             "Verox",
             0,
             false,
             'P'
         )

         3 -> Priest(
             3800,
             2500,
             10.0,
             98.0,
             12.0,
             130.8,
             200.69,
             "Stardusk",
             0,
             false
         )
         else -> {
             println("Bitte wiederhole deine Eingabe. Das hat dich 150 Mana gekostet")
             spAction3()
         }
     }
     println("Stardusk setzt Power Word: Shield ein")
 }


 */
/*override fun spAction4() { // DoT (damage over time) remove
    val attackName = "Mass Dispel"
    if (herp) { // wenn ein dot auf dem Hero liegt...
        dot == false // ...dann wird dieser entfernt
        println("$attackName hat den DoT dispel´t")
        newManaValue -= 150
    } else {
        println("Es gibt keinen DoT Effekt zum dispelen!")
    }
}

 */
