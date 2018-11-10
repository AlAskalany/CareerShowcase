buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-android-extensions:1.3.0")
        classpath("com.google.gms:google-services:4.2.0")
        //classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.0")
        classpath(kotlin("gradle-plugin", version = "1.3.0"))

    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean", Delete::class) {
    delete(rootProject.buildDir)
}