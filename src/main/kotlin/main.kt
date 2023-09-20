import kotlin.concurrent.thread

fun main() {
    var inventory: Map<Int, String> = mapOf(
        1 to "Heal Potion",
        2 to "STR Buff- Potion",
        3 to "AGI Buff-Potion",
        4 to "INT Buff- Potion"
    )
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
        false,
        true,
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
        false,
        true,
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
        false,
        false,
        'M'
    )
    threadList.put(hero3.name, hero3.thread)
    var boss: Boss = Boss(
        20000,
        "Fire/Physical",
        400,
        420,
        150,
        600,
        650,
        "Ragnaros the Firelord",
        "Elemental",
        "Fire Energy" to 100
    )
    var minion: Minion = Minion(
        100,
        "Physical",
        30,
        5,
        20,
        25,
        25,
        "Fire Elemental",
        "Elemental",
        true
    )


}