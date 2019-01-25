import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.0")
    }
}

plugins {
    java
    maven
}

apply {
    plugin("kotlin")
}

group = "org.team2471.lib"
version = "2019"

repositories {
    mavenCentral()
    maven { setUrl("http://first.wpi.edu/FRC/roborio/maven/release") }
    maven { setUrl("http://devsite.ctr-electronics.com/maven/release/") }
}

dependencies {
    // kotlin libs
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.0")

    // frc libs
    implementation("edu.wpi.first.wpilibj:wpilibj-java:2019.1.1")
    implementation("edu.wpi.first.hal:hal-java:2019.1.1")
    implementation("edu.wpi.first.wpiutil:wpiutil-java:2019.1.1")
    implementation("edu.wpi.first.ntcore:ntcore-java:2019.1.1")
    implementation("com.ctre.phoenix:api-java:5.12.0")

    // other
    implementation("com.google.code.gson:gson:2.8.2")
    implementation("com.squareup.moshi:moshi:1.8.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.8.0")
    implementation("com.squareup.moshi:moshi-adapters:1.8.0")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses", "-Xuse-experimental=kotlin.Experimental")
}
