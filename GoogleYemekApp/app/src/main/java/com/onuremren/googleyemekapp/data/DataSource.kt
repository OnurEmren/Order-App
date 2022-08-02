package com.onuremren.googleyemekapp.data

import com.onuremren.googleyemekapp.constans.ItemType
import com.onuremren.googleyemekapp.model.MenuItem

object DataSource {
    val menuItems = mapOf(
        "Kuru Fasülye" to MenuItem(
            name = "Kuru Fasülye",
            description = "Kuru Fasülye",
            price = 15.0,
            type = ItemType.MAIN_COURSE
        ),
        "Nohut" to MenuItem(
            name = "Nohut",
            description = "Nohut",
            price = 15.0,
            type = ItemType.MAIN_COURSE
        ),
        "Tavuk Haşlama" to MenuItem(
            name = "Tavuk Haşlama",
            description = "Haşlanmış patates ve havuç eşliğinde",
            price = 15.0,
            type = ItemType.MAIN_COURSE
        ),
        "Patlıcan Musakka" to MenuItem(
            name = "Patlıcan Musakka",
            description = "Fırınlanmış özel soslu musakka",
            price = 15.0,
            type = ItemType.MAIN_COURSE
        ),
        "Etli Patates" to MenuItem(
            name = "Etli Patates",
            description = "Haşlanmış patates ve dana eti",
            price = 15.0,
            type = ItemType.MAIN_COURSE
        ),
        "Biber Dolma" to MenuItem(
            name = "Biber Dolma",
            description = "Etli biber dolma",
            price = 13.0,
            type = ItemType.SIDE_DISH
        ),
        "Makarna" to MenuItem(
            name = "Makarna",
            description = "Salça soslu Makarna",
            price = 13.0,
            type = ItemType.SIDE_DISH
        ),
        "Pilav" to MenuItem(
            name = "Pilav",
            description = "Pirinç Pilavı",
            price = 13.0,
            type = ItemType.SIDE_DISH
        ),
        "Bulgur Pilavı" to MenuItem(
            name = "Bulgur Pilavı",
            description = "Domatesli salçalı bulgur pilavı",
            price = 13.0,
            type = ItemType.SIDE_DISH
        ),
        "Mantı" to MenuItem(
            name = "Mantı",
            description = "Yoğurt ve salçalı sos ile",
            price = 13.0,
            type = ItemType.SIDE_DISH
        ),
        "Mercimek Çorbası" to MenuItem(
            name = "Mercimek Çorbası",
            description = "Mercimek Çorbası",
            price = 13.0,
            type = ItemType.SIDE_DISH
        ),
        "Salata" to MenuItem(
            name = "Salata",
            description = "Kıvırcık, domates, salatalık ve zeytinyağı",
            price = 7.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Cacık" to MenuItem(
            name = "Cacık",
            description = "Cacık",
            price = 7.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Yoğurt" to MenuItem(
            name = "Yoğurt",
            description = "Yoğurt",
            price = 7.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Kola" to MenuItem(
            name = "Kola",
            description = "Kola",
            price = 10.0,
            type = ItemType.ACCOMPANIMENT
        )
    )
}