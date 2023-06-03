package ru.andreyTw.romanCalculator.telegram.temp

//class MySingleton {
class MySingleton private constructor() {
    var numberOfInstance = instanceCounter

    init {
        instanceCounter++
    }

    companion object {
        private var instanceCounter: Int = 1
        private var uniqueSingletonInstance: MySingleton? = null

        fun getMySingleton(): MySingleton {
            if (uniqueSingletonInstance == null) {
                uniqueSingletonInstance = MySingleton()
            }
            return uniqueSingletonInstance!!
        }
    }
}