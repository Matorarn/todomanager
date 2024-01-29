plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false

    id("io.gitlab.arturbosch.detekt") version "1.23.1"
    id("com.google.devtools.ksp") version "1.9.22-1.0.17"
}
subprojects {
    // Use detekt in all modules
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        buildUponDefaultConfig = true
        config.setFrom("${project.rootDir}/detekt.yml")
    }
    dependencies {
        // Use ktlint rules
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.1")
    }
}