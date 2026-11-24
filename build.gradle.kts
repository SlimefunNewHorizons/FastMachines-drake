import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.3.0"
    id("com.gradleup.shadow") version "9.4.1"
    id("de.eldoria.plugin-yml.bukkit") version "0.8.0"
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

repositories {
    maven("https://pack.drakescraft.cl/builds/maven/")
    mavenLocal()
    mavenCentral()
    maven("https://central.sonatype.com/repository/maven-snapshots/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.alessiodp.com/releases/")
    maven("https://jitpack.io")
    maven("https://maven.drakescraft.cl/")
}

dependencies {
    fun compileOnlyAndTestImpl(dependencyNotation: Any) {
        compileOnly(dependencyNotation)
        testImplementation(dependencyNotation)
    }

    compileOnly(kotlin("stdlib")) // loaded through library loader
    compileOnly(kotlin("reflect")) // loaded through library loader
    compileOnlyAndTestImpl("io.papermc.paper:paper-api:26.2.build.129-stable")
    compileOnlyAndTestImpl("com.github.drakescraft_labs:slimefun-core:11.0-Universal-26.x-SNAPSHOT")
    compileOnly("com.github.drakescraft_labs:SlimefunTranslation:11.0-Universal-26.x-SNAPSHOT")
    compileOnly("com.github.schntgaispock:SlimeHUD:1.3.0")
    compileOnly("com.github.drakescraft_labs:InfinityExpansion-drake:1.20.6-UNIVERSAL-26x-SNAPSHOT")
    compileOnly("com.github.VoperAD:SlimeFrame:8af2379a01")
    compileOnly("net.guizhanss:InfinityExpansion2:8d3e6c40f6")
    // GuizhanLib trae bstats antiguo (p. ej. ctor JavaPlugin); sombrea la 3.1.0 y provoca NoSuchMethodError en runtime.
    implementation("net.guizhanss:guizhanlib-all:2.5.0") {
        exclude(group = "org.bstats", module = "bstats-bukkit")
    }
    implementation("net.guizhanss:guizhanlib-kt-all:0.2.0") {
        exclude(group = "org.bstats", module = "bstats-bukkit")
    }
    implementation("org.bstats:bstats-bukkit:3.1.0")

    testImplementation(kotlin("test"))
    testImplementation("org.mockbukkit.mockbukkit:mockbukkit-v26.2:4.116.1")
}

group = "com.github.drakescraft_labs"
description = "FastMachines"

version = "11.0-Universal-26.x-SNAPSHOT"

/** Paquete real del fork Drake (upstream Guizhan); coincide con las fuentes Kotlin. */
val mainPackage = "net.guizhanss.fastmachines"

java {
    disableAutoTargetJvm()
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

kotlin {
    compilerOptions {
        javaParameters = true
        jvmTarget = JvmTarget.JVM_25
    }
}

// Shadow necesita el JAR de Kotlin como entrada; el clasificador "thin" evita confundirlo con el fat JAR del servidor.
tasks.named<Jar>("jar") {
    enabled = true
    archiveClassifier.set("thin")
}

tasks.shadowJar {
    fun doRelocate(from: String, to: String? = null) {
        val last = to ?: from.split(".").last()
        relocate(from, "com.github.drakescraft_labs.fastmachines.libs.$last")
    }

    doRelocate("net.byteflux.libby")
    doRelocate("net.guizhanss.guizhanlib")
    doRelocate("org.bstats")
    doRelocate("io.papermc.lib", "com.github.drakescraft_labs.fastmachines.libs.paperlib")
    // minimize() podía quitar la clase principal FastMachines del JAR sombreado
    archiveClassifier.set("")
    archiveFileName.set("FastMachines-11.0-Universal-26.x-SNAPSHOT.jar")
}

bukkit {
    main = "$mainPackage.FastMachines"
    apiVersion = "1.18"
    authors = listOf("ybw0014")
    description = "More Slimefun machines that bulk craft items with all shapeless recipes"
    depend = listOf("Slimefun")
    softDepend = listOf(
        "GuizhanLibPlugin",
        "SlimefunTranslation",
        "InfinityExpansion",
        "SlimeFrame",
        "SlimeHUD",
        "InfinityExpansion2",
    )
    loadBefore = listOf(
        "SlimeCustomizer",
        "RykenSlimeCustomizer",
        "SlimeFunRecipe"
    )
}

tasks.runServer {
    downloadPlugins {
        // Slimefun
        url("https://builds.guizhanss.com/api/download/SlimefunGuguProject/Slimefun4/master/latest")
        // SlimeHUD
        url("https://blob.build/dl/SlimeHUD/Dev/latest")
        // GuizhanCraft for testing convenient
        url("https://builds.guizhanss.com/api/download/ybw0014/GuizhanCraft/master/latest")
    }
    jvmArgs("-Dcom.mojang.eula.agree=true")
    minecraftVersion("1.21.1")
}

tasks.test {
    useJUnitPlatform()
}
