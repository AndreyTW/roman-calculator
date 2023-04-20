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
