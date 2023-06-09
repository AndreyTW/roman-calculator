rootProject.name = "roman-calculator"

pluginManagement {
    val kotlinVersion: String by settings

    repositories {
        mavenCentral()
    }

    plugins {
        kotlin("jvm") version kotlinVersion
    }
}

include("roman-calculator-core")
include("roman-calculator-console")
include("roman-calculator-telegram")
