package com.example.weatheuiapp.data.model

object CityMapping {
    private val cityMap = mapOf(
        "Москва" to "Moscow",
        "Санкт-Петербург" to "Saint Petersburg",
        "Новосибирск" to "Novosibirsk",
        "Екатеринбург" to "Yekaterinburg",
        "Казань" to "Kazan",
        "Нижний Новгород" to "Nizhny Novgorod",
        "Челябинск" to "Chelyabinsk",
        "Самара" to "Samara",
        "Омск" to "Omsk",
        "Ростов-на-Дону" to "Rostov-on-Don",
        "Уфа" to "Ufa",
        "Красноярск" to "Krasnoyarsk",
        "Воронеж" to "Voronezh",
        "Пермь" to "Perm",
        "Волгоград" to "Volgograd",
        "Краснодар" to "Krasnodar",
        "Саратов" to "Saratov",
        "Тюмень" to "Tyumen",
        "Тольятти" to "Tolyatti",
        "Ижевск" to "Izhevsk",
        "Барнаул" to "Barnaul",
        "Иркутск" to "Irkutsk",
        "Ульяновск" to "Ulyanovsk",
        "Хабаровск" to "Khabarovsk",
        "Ярославль" to "Yaroslavl",
        "Владивосток" to "Vladivostok",
        "Махачкала" to "Makhachkala",
        "Томск" to "Tomsk",
        "Оренбург" to "Orenburg",
        "Кемерово" to "Kemerovo",
        "Новокузнецк" to "Novokuznetsk",
        "Рязань" to "Ryazan",
        "Астрахань" to "Astrakhan",
        "Набережные Челны" to "Naberezhnye Chelny",
        "Пенза" to "Penza",
        "Липецк" to "Lipetsk",
        "Киров" to "Kirov",
        "Чебоксары" to "Cheboksary",
        "Тула" to "Tula",
        "Калининград" to "Kaliningrad",
        "Балашиха" to "Balashikha",
        "Курск" to "Kursk",
        "Ставрополь" to "Stavropol",
        "Улан-Удэ" to "Ulan-Ude",
        "Тверь" to "Tver",
        "Магнитогорск" to "Magnitogorsk",
        "Сочи" to "Sochi",
        "Иваново" to "Ivanovo",
        "Брянск" to "Bryansk",
        "Таганрог" to "Taganrog"
    )

    fun getEnglishCityName(russianName: String): String? {
        return cityMap[russianName]
    }

    fun getAllRussianCities(): List<String> {
        return cityMap.keys.toList()
    }
}