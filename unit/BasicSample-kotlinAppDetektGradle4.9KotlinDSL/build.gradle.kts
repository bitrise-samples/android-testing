import io.gitlab.arturbosch.detekt.extensions.DetektExtension

buildscript {

    repositories {
        jcenter {
            content {
                // just allow to include kotlinx projects
                // detekt needs 'kotlinx-html' for the html report
                includeGroup("org.jetbrains.kotlinx")
            }
        }
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
    toolVersion = "${ProjectVersions.DETEKT_VERSION}"
    failFast = true
    input = files("${projectDir}", "**/src/main/java", "**/src/main/kotlin")
    config = files("${project.rootDir}/detekt.yml")
    buildUponDefaultConfig = true
    ignoreFailures = true

    reports {
        html.enabled = true
        xml.enabled = true
        txt.enabled = true
    }
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}
