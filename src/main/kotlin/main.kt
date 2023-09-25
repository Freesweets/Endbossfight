import kotlin.concurrent.thread

var dot: Boolean =
    false //Wird zu begin der Runde gecheckt. Falls true dann erleidet der Character entsprechend Schaden. Default false, wird durch Boss attac getriggert

fun main() {

    var hero1: Tank = Tank(
        7800,
        0,
        68.0,
        15.0,
        25.0,
        450.8,
        280.0,
        "Schanzentor",
        30,

        )

    var hero2: Rogue = Rogue(
        4200,
        150,
        40.0,
        35.0,
        95.0,
        235.5,
        150.5,
        "Verox",
        10,
        'P'
    )

    var hero3: Priest = Priest(
        3800,
        2500,
        10.0,
        98.0,
        12.0,
        130.8,
        200.69,
        "Stardusk",
        10
    )

    var boss: Boss = Boss(
        30000.0,
        400,
        420,
        400,
        "Ragnaros the Firelord",
        0
    )
    var minion: Minion = Minion(
        100.0,
        30,
        5,
        5,
        "Fire Elemental",
        true

    )
    val group: List<Hero> = listOf(hero1, hero2, hero3)
    var round = 1
    var gameOver = false


    fun bossAttackRandom(): (Hero) -> Any { //greift auf eine zufällige Aktion des Bosses zu und führt diese aus
        var action = boss.bossActionList.random()
        return action
    }

    fun chooseTarget(): Hero { //bestimmt das Ziel des Angriffes. Das Ziel ist immer der Hero mit dem höchstes Thread Wert
        var target = group.maxBy { it.thread }
        return target
    }

    if (!(boss.hp > 0 && (hero1.hp >= 0 || hero2.hp >= 0 || hero3.hp >= 0))) {
        gameOver = true
    } //Bedingungen für das abschliessen des Spiels
    println( //println zu Begninn des Spiels
        """
        Die 3 Helden haben sich bis zu Ragnaros dem Feuerlord vorgekämpft. 
        Majordomus Exekutus sieht die Helden in der Ferne. Aus Panik versucht er Ragnaros zu beschwören bevor es zu spät ist...
        Ragnaros: TOO SOON!! YOU SUMMONED ME TOO SOON!! YOU WILL DIE FOR YOUR MUSTAKES MAJORDOMUS!
        Ragnaros erschlägt Majordomus mit Sulfuras und wendet sich den Helden zu....
    """.trimIndent()
    )

    while (gameOver == false) { //readln Optionen für den Spieler
        println("Wähle eine Tank Aktion aus...")
        var warriorInput: Int? = null
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
        } else if (warriorInput == 5) {
            hero1.inventory()
        } else {
            warriorInput = null
        }
        println("Wähle eine Rogue Aktion aus...")
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
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (rogueInput == 5) {
            hero2.inventory()
        } else {
            rogueInput = null
        }
        println("Wähle eine Priest Aktion aus...")
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
        var priestInput: Int? = readln().toIntOrNull()  //Aktion des Spilers
        if (priestInput == 1) { //Aktion des Spilers
            boss.hp = boss.hp - hero3.spAction1()
            println("${boss.name} hat noch ${boss.hp} übrig.")
        } else if (priestInput == 2) {
            hero3.spAction2()
        } else if (priestInput == 3) {
            hero3.spAction3()
        } else if (priestInput == 4) {
            hero3.spAction4()
        } else {
            priestInput = null
        }
        val target = chooseTarget()
        val bossAttacke = bossAttackRandom()
        bossAttacke(target)
        round++
        println("$round. Runde")
    }

}