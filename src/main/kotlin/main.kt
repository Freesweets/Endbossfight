fun main() {
    var inventory: Map<Int, String> = mapOf(
        1 to "Heal Potion",
        2 to "STR Buff- Potion",
        3 to "AGI Buff-Potion",
        4 to "INT Buff- Potion"
    )

    var hero1: Character = Character(
        1200,
        "Wut" to 100,
        "Tank",
        "1H Axt" to "Schild",
        "Waffenschaden/Blutung",
        75.0,
        15.0,
        50,
        450.8,
        280.0,
        "Punchhole",
        "Protection-Warrior",
        true,
        'P'
    )
    var hero2: Character = Character(
        650,
        "Energy" to 150,
        "DPS",
        "1H Schwert" to "Dolch",
        "Poison/Bleed/Shadow",
        60.0,
        30.0,
        95,
        235.5,
        150.5,
        "Verox",
        "Subtility-Rogue",
        true,
        'P'
    )
    var hero3: Character = Character(
        590,
        "Mana" to 1500,
        "DPS/Off-Heal",
        "Main-Hand" to "Off-Hand",
        "Shadow/Holy",
        10.0,
        98.0,
        12,
        130.8,
        200.69,
        "Valen",
        "Shadow-Priest",
        false,
        'M'
    )
    var boss: Boss = Boss(
        6500,
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
    hero1.attack1()

}