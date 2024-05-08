plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17


}

sourceSets {
    main{
        java {
            srcDir("android-inner")
            srcDir("android-outer")
        }
    }
}