buildscript {

    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectVersions.KOTLIN_VERSION}")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version(ProjectVersions.DETEKT_VERSION)
}

apply(plugin="io.gitlab.arturbosch.detekt")

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${ProjectVersions.DETEKT_VERSION}")
}

detekt {
    failFast = true
    config = files("${project.rootDir}/detekt.yml")
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}
