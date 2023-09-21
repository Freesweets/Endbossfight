var dot: Boolean =
    false //Wird zu begin der Runde gecheckt. Falls true dann erleidet der Character entsprechend Schaden. Default false, wird durch Boss attac getriggert

fun main() {
    var threadList: MutableMap<String, Int> = mutableMapOf()
    var hero1: Character = Character(
        7800,
        0,
        "Tank",
        "1H Axt" to "Schild",
        "Waffenschaden/Blutung",
        68.0,
        15.0,
        25.0,
        450.8,
        280.0,
        "Schanzentor",
        30,
        "Protection-Warrior",
        'P'
    )
    threadList.put(hero1.name, hero1.thread)
    var hero2: Character = Character(
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
    threadList.put(hero2.name, hero2.thread)
    var hero3: Character = Character(
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
    threadList.put(hero3.name, hero3.thread)
    var boss: Boss = Boss(
        20000.0,
        400,
        420,
        400,
        "Ragnaros the Firelord",
        0
    )
    var minion: Minion = Minion(
        100,
        30,
        5,
        5,
        "Fire Elemental",
        true

    )
    val heroes: List<Character> = listOf(hero1, hero2, hero3)
    var round = 1
    var gameOver = false
    var input = readln().toIntOrNull()

    println("Die 3 Helden haben sich bis zu Ragnaros dem Feuerlord vorgekämpft")
    while (!gameOver) {
        println("$round.Runde")
        println("------")
        for (hero in heroes) {
            if (boss.isAlive()) {
                var dmg = hero1.tankAction1(boss.hp)
            }
        }
    }

    do {
        println("Was willst du tun?")
        println("1 -> Tank Aktion wählen")
        println("2 -> Rogue Aktion wählen")
        println("3 -> Priest Aktion wählen")
    } while (!gameOver)



    while (!gameOver) {
        println("Was willst du tun?")
        println("1 -> Tank Aktion wählen")
        println("2 -> Rogue Aktion wählen")
        println("3 -> Priest Aktion wählen")
        if (input == 1) {
            println(
                """
            Tank Aktionen:
            1 -> Taunt (erhöht deinen Thread und erzeugt 15 Wut)
            2 -> Last man standing (Verbraucht 50 Wut oder ist kostenlos falls deine HP unter 2500 liegt. Heilt dich auf 7800 HP)
            3 -> Heroic Strike (verursacht moderaten Schaden und erzeugt 15 Wut)
            4 -> Thunderclap (verursacht moderaten Schaden an allen Gegnern und erzeugt 20 Wut)
            5 -> Inventar
        """.trimIndent()
            )
            if (input == 1) {
                hero1.tankAction1()
            } else if (input == 2) {
                hero1.tankActiion2()
            } else if (input == 3) {
                boss.hp = boss.hp - hero1.tankAction3()
            } else if (input == 4) {
                boss.hp = boss.hp - hero1.tankAction4()
            } else if (input == 5) {
                hero1.inventory()
            }
        } else if (input == 2) {
            println(
                """
            Rogue Aktionen:
            1 -> Sinister Stiker (verursacht moderaten Schaden. Koster 15 Energy)
            2 -> Ambush (verursacht hohen Schaden. Der angerichtete Schaden wird erhöht falls in der Runde zuvor Sinister Strike eingesetzt wurde: WOMBO COMBO! - Kostet 25 Energy)
            3 -> Shadow Strike (hoher Schaden. Setzt verursachten Schaden von physisch zu magisch und vice versa. Sollte der Schaden bereits auf magisch eingestellt sein- verursacht Shadow Strike Bonusschaden und kostet keine Energy)
            4 -> Tricks of the trade (geringer Schaden. Reduziert den Thread des Rogues und erhöht den Thread des Tanks)
            5 -> Inventar
        """.trimIndent()
            )
        } else if (input == 3) {
            println(
                """
            Priest Aktionen:        
            1 -> Mind Blast (hoher Schaden. Kostet 250 Mana)
            2 -> Fade (reduziert den Thread des Priesters auf 0)
            3 -> Power Word: Shield (wählt ein Gruppenmitglied aus. Das gewählte Ziel erhält im nächsten Zug keinen Schaden)
            4 -> Mass Dispel (entfernt einen damage over time effekt)
            5 -> Inventar
        """.trimIndent()
            )
        }
        gameOver = !(boss.hp > 0 && (hero1.hp >= 0 || hero2.hp >= 0 || hero3.hp >= 0))

    }
}
